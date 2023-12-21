import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        char[][] chess = new char[n][m];
        int[][][] sum = new int[n + 1][m + 1][2];
        char[] color = new char[]{'B', 'W'};

        for(int i = 0; i < n; i++) {
            chess[i] = br.readLine().toCharArray();

            for(int j = 0; j < m; j++) {
                sum[i + 1][j + 1][0] = sum[i + 1][j][0] + sum[i][j + 1][0] - sum[i][j][0];
                sum[i + 1][j + 1][1] = sum[i + 1][j][1] + sum[i][j + 1][1] - sum[i][j][1];

                if (color[(i + j) % 2] != chess[i][j]) {
                    sum[i + 1][j + 1][0]++;
                }
                if (color[(i + j + 1) % 2] != chess[i][j]) {
                    sum[i + 1][j + 1][1]++;
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for(int i = 0; i < n - k + 1; i++) {
            for(int j = 0; j < m - k + 1; j++) {
                int total_B = sum[i + k][j + k][0] - sum[i][j + k][0] - sum[i + k][j][0] + sum[i][j][0];
                int total_W = sum[i + k][j + k][1] - sum[i][j + k][1] - sum[i + k][j][1] + sum[i][j][1];

                min = Math.min(min, Math.min(total_B, total_W));
            }
        }

        bw.write(min + "");
        bw.close();
    }
}