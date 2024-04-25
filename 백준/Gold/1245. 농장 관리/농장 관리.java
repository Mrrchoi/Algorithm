import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    public static int[][] delta = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
    public static boolean isOk;

    public static void bfs(int[][] map, boolean[][] visited, int n, int m, Point p) {
        Queue<Point> queue = new LinkedList<>();

        queue.add(p);
        visited[p.x][p.y] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int[] d : delta) {
                int nr = now.x + d[0];
                int nc = now.y + d[1];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }

                if (map[nr][nc] > map[p.x][p.y]) {
                    isOk = false;
                }
                else if (!visited[nr][nc] && map[nr][nc] == map[p.x][p.y]) {
                    queue.add(new Point(nr, nc));
                    visited[nr][nc] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visited = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    isOk = true;

                    bfs(map, visited, n, m, new Point(i, j));

                    if (isOk) {
                        count++;
                    }
                }
            }
        }

        bw.write(count + "");
        bw.close();
    }
}