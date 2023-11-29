import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {
    public static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static int search(int[][] map, Point p) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visit = new boolean[map.length][map.length];
        int depth = 0;

        queue.offer(p);
        visit[p.x][p.y] = true;

        while (!queue.isEmpty()) {
            int len = queue.size();;

            for(int i = 0; i < len; i++) {
                Point now = queue.poll();

                for(int j = 0; j < delta.length; j++) {
                    int nr = now.x + delta[j][0];
                    int nc = now.y + delta[j][1];

                    if(nr < 0 || nr >= map.length || nc < 0 || nc >= map.length || map[p.x][p.y] == map[nr][nc] || visit[nr][nc]) {
                        continue;
                    }

                    if(map[nr][nc] == 0) {
                        queue.offer(new Point(nr, nc));
                        visit[nr][nc] = true;
                    }
                    else {
                        return depth;
                    }
                }
            }

            depth++;
        }

        return Integer.MAX_VALUE;
    }

    public static void numbering(int[][] map, boolean[][] visit, int k, Point p) {
        Queue<Point> queue = new LinkedList<>();

        queue.offer(p);
        map[p.x][p.y] = k;
        visit[p.x][p.y] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for(int i = 0; i < delta.length; i++) {
                int nr = now.x + delta[i][0];
                int nc = now.y + delta[i][1];

                if(nr < 0 || nr >= map.length || nc < 0 || nc >= map.length || map[nr][nc] != 1 || visit[nr][nc]) {
                    continue;
                }

                queue.offer(new Point(nr, nc));
                map[nr][nc] = k;
                visit[nr][nc] = true;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visit = new boolean[N][N];
        int k = 1;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 1 && !visit[i][j]) {
                    numbering(map, visit, k++, new Point(i, j));
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] != 0) {
                    min = Math.min(min, search(map, new Point(i, j)));
                }
            }
        }

        bw.write(min + "");
        bw.close();
    }
}