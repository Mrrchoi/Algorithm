import java.util.*;
import java.io.*;

public class Main {
    public static int bfs(int[][] castle,  int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int[][][] visit = new int[n][m][2];

        queue.add(new int[]{0, 0, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for(int[] d : delta) {
                int nr = now[0] + d[0];
                int nc = now[1] + d[1];
                int sword = now[2];

                if(nr < 0 || nr >= n || nc < 0 || nc >= m || (sword == 0 && castle[nr][nc] == 1) || visit[nr][nc][sword] != 0) {
                    continue;
                }

                visit[nr][nc][sword] = visit[now[0]][now[1]][sword] + 1;

                if(castle[nr][nc] == 2) {
                    visit[nr][nc][1] = visit[now[0]][now[1]][sword] + 1;
                    sword = 1;
                }

                queue.add(new int[]{nr, nc, sword});

                if(nr == n - 1 && nc == m - 1) {
                    return visit[nr][nc][sword];
                }
            }
        }

        return Integer.MAX_VALUE;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[][] castle = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                castle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = bfs(castle, n, m);

        bw.write(result > t ? "Fail" : result + "");
        bw.close();
    }
}