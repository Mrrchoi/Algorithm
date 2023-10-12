import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    public static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static void bfs(int[][] arctic, boolean[][] visit, Point start) {
        Queue<Point> queue = new LinkedList<>();

        queue.offer(start);
        visit[start.x][start.y] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nr = now.x + delta[i][0];
                int nc = now.y + delta[i][1];

                if(nr < 0 || nr >= arctic.length || nc < 0 || nc >= arctic[0].length || arctic[nr][nc] == 0 || visit[nr][nc]) continue;

                queue.offer(new Point(nr, nc));
                visit[nr][nc] = true;
            }
        }

    }
    public static int thaw(int[][] arctic, ArrayList<Point> iceberg) {
        ArrayList<Integer> thaw_ice;
        int year = 1;

        while (!iceberg.isEmpty()) {
            thaw_ice = new ArrayList<>();

            for(Point now : iceberg) {
                int count = 0;

                for(int i = 0; i < 4; i++) {
                    int nr = now.x + delta[i][0];
                    int nc = now.y + delta[i][1];

                    if(nr < 0 || nr >= arctic.length || nc < 0 || nc >= arctic[0].length || arctic[nr][nc] != 0) continue;

                    count++;
                }

                thaw_ice.add(count);
            }

            for(int i = 0; i < iceberg.size(); i++) {
                Point now = iceberg.get(i);
                int minus = thaw_ice.get(i);

                arctic[now.x][now.y] -= minus;

                if(arctic[now.x][now.y] <= 0){
                    arctic[now.x][now.y] = 0;
                    iceberg.remove(i);
                    thaw_ice.remove(i);
                    i--;
                }
            }

            boolean[][] visit = new boolean[arctic.length][arctic[0].length];
            boolean check = false;

            for(Point now : iceberg) {
                if(!visit[now.x][now.y]) {
                    if(check) return year;

                    bfs(arctic, visit, now);

                    check = true;
                }
            }

            year++;
        }

        return 0;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arctic = new int[n][m];
        ArrayList<Point> iceberg = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arctic[i][j] = Integer.parseInt(st.nextToken());

                if(arctic[i][j] != 0) iceberg.add(new Point(i, j));
            }
        }

        bw.write(thaw(arctic, iceberg) + "");
        bw.close();
    }
}