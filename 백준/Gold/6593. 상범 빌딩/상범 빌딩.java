import java.util.*;
import java.io.*;

public class Main {
    public static class Point {
        int l;
        int r;
        int c;

        public Point(int l, int r, int c) {
            this.l = l;
            this.r = r;
            this.c = c;
        }
    }
    public static int bfs(char[][][] building, int l, int r, int c, Point start) {
        Queue<Point> queue = new LinkedList<>();
        int[][] delta = {{0, 0, -1}, {0, 0, 1}, {0, -1, 0}, {0, 1, 0}, {-1, 0, 0}, {1, 0, 0}};
        int[][][] visit = new int[l][r][c];

        queue.add(start);
        visit[start.l][start.r][start.c] = 1;

        while (!queue.isEmpty()) {
            int len = queue.size();

            for(int i = 0; i < len; i++) {
                Point now = queue.poll();

                for(int[] d : delta) {
                    int nl = now.l + d[0];
                    int nr = now.r + d[1];
                    int nc = now.c + d[2];

                    if(nl < 0 || nl >= l || nr < 0 || nr >= r || nc < 0 || nc >= c || visit[nl][nr][nc] != 0 || building[nl][nr][nc] == '#') continue;

                    queue.add(new Point(nl, nr, nc));
                    visit[nl][nr][nc] = visit[now.l][now.r][now.c] + 1;

                    if(building[nl][nr][nc] == 'E') return visit[nl][nr][nc] - 1;
                }
            }
        }

        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (true){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(l == 0 && r == 0 && c == 0) break;

            char[][][] building = new char[l][r][c];
            Point start = new Point(0, 0, 0);

            for(int i = 0; i < l; i++) {
                for(int j = 0; j < r; j++) {
                    building[i][j] = br.readLine().toCharArray();

                    for(int k = 0; k < c; k++) {
                        if(building[i][j][k] == 'S') {
                            start = new Point(i, j, k);
                        }
                    }
                }

                br.readLine();
            }

            int result = bfs(building, l, r, c, start);

            if(result == -1) bw.write("Trapped!\n");
            else bw.write("Escaped in " + result + " minute(s).\n");
        }

        bw.close();
    }
}