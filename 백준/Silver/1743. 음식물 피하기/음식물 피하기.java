import java.util.*;
import java.io.*;
import java.awt.*;

public class Main {
    public static int[][] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static int bfs(int[][] map, boolean[][] visited, int n, int m, Point p) {
        Queue<Point> queue = new LinkedList<>();
        int count = 1;

        queue.add(p);
        visited[p.x][p.y] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nr = now.x + delta[i][0];
                int nc = now.y + delta[i][1];

                if(nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc] || map[nr][nc] == 0) {
                    continue;
                }

                queue.add(new Point(nr, nc));
                visited[nr][nc] = true;
                count++;
            }
        }

        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        int max = 0;

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            map[r][c] = 1;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    max = Math.max(max, bfs(map, visited, n, m, new Point(i, j)));
                }
            }
        }


        bw.write(max + "");
        bw.close();
    }
}