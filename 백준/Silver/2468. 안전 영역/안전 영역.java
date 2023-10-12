import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    public static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static int size = 1;
    public static void bfs(int[][] area, boolean[][] visit, Point start, int std) {
        Queue<Point> queue = new LinkedList<>();

        queue.add(start);
        visit[start.x][start.y] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nr = now.x + delta[i][0];
                int nc = now.y + delta[i][1];

                if(nr < 0 || nr >= area.length || nc < 0 || nc >= area.length || area[nr][nc] <= std || visit[nr][nc]) continue;

                queue.add(new Point(nr, nc));
                visit[nr][nc] = true;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        TreeSet<Integer> set = new TreeSet<>();
        int n = Integer.parseInt(br.readLine());
        int[][] area = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < n; j++) {
                set.add(area[i][j] = Integer.parseInt(st.nextToken()));
            }
        }

        for(int std : set) {
            boolean[][] visit = new boolean[n][n];
            int count = 0;

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(!visit[i][j] && area[i][j] > std) {
                        bfs(area, visit, new Point(i, j), std);
                        count++;
                    }
                }
            }

            size = Math.max(size, count);
        }

        bw.write(size + "");
        bw.close();
    }
}