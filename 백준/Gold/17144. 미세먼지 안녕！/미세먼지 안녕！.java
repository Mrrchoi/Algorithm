import java.io.*;
import java.util.*;

public class Main {
    public static int[][][] delta = {{{0, 1}, {-1, 0}, {0, -1}, {1, 0}}, {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[][] house = new int[r][c];
        int[][] cleaner = new int[2][2];

        for(int i = 0, idx = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < c; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());

                if(house[i][j] == -1) {
                    cleaner[idx][0] = i;
                    cleaner[idx][1] = j;
                    idx++;
                }
            }
        }

        for(int i = 0; i < t; i++) {
            int[][] result = new int[r][c];

            for(int j = 0; j < r; j++) {
                for(int k = 0; k < c; k++) {
                    if (house[j][k] == 0 || house[j][k] == -1) continue;

                    int count = 0;

                    for(int l = 0; l < 4; l++) {
                        int nr = j + delta[0][l][0];
                        int nc = k + delta[0][l][1];

                        if(nr < 0 || nr >= r || nc < 0 || nc >= c || house[nr][nc] == -1) continue;

                        result[nr][nc] += house[j][k] / 5;
                        count++;
                    }

                    result[j][k] -= (house[j][k] / 5) * count;
                }
            }

            for(int j = 0; j < r; j++) {
                for(int k = 0; k < c; k++) {
                    house[j][k] += result[j][k];
                }
            }

            for(int j = 0; j < 2; j++) {
                int nr = cleaner[j][0];
                int nc = cleaner[j][1];
                int turn = 0, prev = 0, next = 0;

                while (true) {
                    nr += delta[j][turn][0];
                    nc += delta[j][turn][1];

                    if (house[nr][nc] == -1) break;

                    next = house[nr][nc];
                    house[nr][nc] = prev;
                    prev = next;

                    int next_nr = nr + delta[j][turn][0];
                    int next_nc = nc + delta[j][turn][1];

                    if(j == 0 && (next_nr < 0 || next_nr > cleaner[j][0] || next_nc < 0 || next_nc >= c)) turn++;
                    else if(j == 1 && (next_nr < cleaner[j][0] || next_nr >= r || next_nc < 0 || next_nc >= c)) turn++;
                }
            }
        }

        int total = 2;

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                total += house[i][j];
            }
        }

        bw.write(total + "");
        bw.close();
    }
}