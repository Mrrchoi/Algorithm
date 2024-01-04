import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {
    public static int[][] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static int bfs(char[][] map, int n, int m, Point p) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visit = new boolean[n][m];
        int depth = 0;

        queue.add(p);
        visit[p.x][p.y] = true;

        while (!queue.isEmpty()) {
            int len = queue.size();

            for(int i = 0; i < len; i++) {
                Point now = queue.poll();

                for(int[] d : delta) {
                    int nx = now.x + d[0];
                    int ny = now.y + d[1];

                    if(nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny] || map[nx][ny] == 'W') continue;

                    queue.add(new Point(nx, ny));
                    visit[nx][ny] = true;
                }
            }

            depth++;
        }

        return depth - 1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] map = new char[n][m];
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 'L') {
                    int result = bfs(map, n, m, new Point(i, j));

                    max = Math.max(max, result);
                }
            }
        }

        bw.write(max + "");
        bw.close();
    }
}