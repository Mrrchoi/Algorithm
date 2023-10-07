import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
    public static int[][] delta = {{0, -1}, {-1, 0}, {0, 1}};
    public static int max = Integer.MIN_VALUE;
    public static int bfs(int[][] castle, Point[] archer, int d) {
        boolean[][] check = new boolean[castle.length][castle[0].length];
        int kill = 0;

        for(int i = 0; i < castle.length; i++) {
            Point[] attack = new Point[3];
            for(int j = 0; j < 3; j++) {
                Queue<Point> queue = new LinkedList<>();
                boolean[][] visit = new boolean[castle.length - i][castle[0].length];
                int count = 1;

                queue.offer(new Point(archer[j].x - i, archer[j].y));

                loop: while (!queue.isEmpty() && count <= d) {
                    int len = queue.size();

                    for(int k = 0; k < len; k++) {
                        Point now = queue.poll();

                        for(int l = 0; l < delta.length; l++) {
                            int nr = now.x + delta[l][0];
                            int nc = now.y + delta[l][1];

                            if(nr < 0 || nr >= visit.length || nc < 0 || nc >= visit[0].length || visit[nr][nc]) continue;

                            if(castle[nr][nc] == 0 || check[nr][nc]) {
                                queue.offer(new Point(nr, nc));
                                visit[nr][nc] = true;
                            }
                            else {
                                attack[j] = new Point(nr, nc);
                                break loop;
                            }
                        }
                    }

                    count++;
                }
            }

            for(int j = 0; j < 3; j++) {
                if(attack[j] != null && !check[attack[j].x][attack[j].y]) {
                    check[attack[j].x][attack[j].y] = true;
                    kill++;
                }
            }
        }

        return kill;
    }
    public static void combination(int[][] castle, int d, int[] target, int idx, int value) {
        if(idx == target.length) {
            Point[] archer = new Point[3];

            for(int i = 0; i < 3; i++) archer[i] = new Point(castle.length, target[i]);

            max = Math.max(max, bfs(castle, archer, d));

            return;
        }
        else if(value == castle[0].length) return;

        target[idx] = value;
        combination(castle, d, target, idx + 1, value + 1);
        combination(castle, d, target, idx, value + 1);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[][] castle = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < m; j++){
                castle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combination(castle, d, new int[3], 0, 0);

        bw.write(max + "");
        bw.close();
    }
}