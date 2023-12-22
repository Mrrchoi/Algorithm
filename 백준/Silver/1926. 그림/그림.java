import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {
    public static int bfs(int[][] drawing, boolean[][] visit, Point p) {
        Queue<Point> queue = new LinkedList<>();
        int[][] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int count = 1;

        queue.add(p);
        visit[p.x][p.y] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for(int[] d : delta) {
                int nr = now.x + d[0];
                int nc = now.y + d[1];

                if(nr < 0 || nr >= drawing.length || nc < 0 || nc >= drawing[0].length || drawing[nr][nc] == 0 || visit[nr][nc]) continue;

                queue.add(new Point(nr, nc));
                visit[nr][nc] = true;
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
        int[][] drawing = new int[n][m];
        boolean[][] visit = new boolean[n][m];
        int count = 0, max = 0;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < m; j++) {
                drawing[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(drawing[i][j] == 1 && !visit[i][j]) {
                    count++;
                    max = Math.max(max, bfs(drawing, visit, new Point(i, j)));
                }
            }
        }

        bw.write(count + "\n" + max);
        bw.close();
    }
}