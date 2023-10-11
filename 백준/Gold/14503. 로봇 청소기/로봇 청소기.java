import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    public static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static int cleaning_area(int[][] area, Point vacuum, int d) {
        boolean[][] visit = new boolean[area.length][area[0].length];
        int cleaning = 0;

        while(true) {
            if(area[vacuum.x][vacuum.y] == 0 && !visit[vacuum.x][vacuum.y]) {
                visit[vacuum.x][vacuum.y] = true;
                cleaning++;
            }

            int possible = 0;

            for(int i = 0; i < 4; i++) {
                int nr = vacuum.x + delta[i][0];
                int nc = vacuum.y + delta[i][1];

                if(area[nr][nc] == 0 && !visit[nr][nc]) possible++;
            }

            if(possible == 0) {
                int nr = vacuum.x + delta[(d + 2) % 4][0];
                int nc = vacuum.y + delta[(d + 2) % 4][1];

                if(area[nr][nc] == 1) break;
                else {
                    vacuum.x = nr;
                    vacuum.y = nc;
                }
            }
            else {
                d = d -1 < 0 ? 3 : d - 1;

                int nr = vacuum.x + delta[d % 4][0];
                int nc = vacuum.y + delta[d % 4][1];

                if(area[nr][nc] == 0 && !visit[nr][nc]) {
                    vacuum.x = nr;
                    vacuum.y = nc;
                }
            }
        }

        return cleaning;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] area = new int[n][m];

        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        Point vacuum = new Point(r, c);

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < m; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(cleaning_area(area, vacuum, d) + "");
        bw.close();
    }
}