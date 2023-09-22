import java.util.*;
import java.io.*;
import java.awt.Point;

public class Solution {
    static int[][] pipe = {{0, 0, 0, 0}, {1, 1, 1, 1}, {1, 0, 1, 0}, {0, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 0}, {0, 0, 1, 1}, {1, 0, 0, 1}};
    static int[][] group = {{1, 2, 5, 6}, {1, 3, 6, 7}, {1, 2, 4, 7}, {1, 3, 5, 4}};
    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static int bfs(int[][] tunnel, int r, int c, int l) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visit = new boolean[tunnel.length][tunnel[0].length];
        int count = 1;

        queue.offer(new Point(r, c));
        visit[r][c] = true;

        l--;

        while (!queue.isEmpty() && l != 0) {
            int len = queue.size();

            for(int i = 0; i < len; i++) {
                Point now = queue.poll();

                for(int j = 0; j < 4; j++){
                    if(pipe[tunnel[now.x][now.y]][j] == 0) continue;

                    int nr = now.x + delta[j][0];
                    int nc = now.y + delta[j][1];
                    boolean ok = false;

                    if(0 <= nr && nr < tunnel.length && 0 <= nc && nc < tunnel[0].length && !visit[nr][nc]) {
                        for(int group_num : group[j]) {
                            if(group_num == tunnel[nr][nc]) {
                                ok = true;
                                break;
                            }
                        }

                        if(ok) {
                            queue.offer(new Point(nr, nc));
                            visit[nr][nc] = true;
                            count++;
                        }
                    }
                }
            }

            l--;
        }

        return count;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int test_case = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test_case; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            int[][] tunnel = new int[n][m];

            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                for(int j = 0; j < m; j++) {
                    tunnel[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            bw.write("#" + t + " " + bfs(tunnel, r, c, l) + "\n");
        }

        bw.close();
    }
}