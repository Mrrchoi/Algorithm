import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[][][] dp = new int[21][21][21];

        for(int i = 0; i <= 20; i++) {
            for (int j = 0; j <= 20; j++) {
                for (int k = 0; k <= 20; k++) {
                    if (i == 0 || j == 0 || k == 0) dp[i][j][k] = 1;
                    else if (i < j && j < k) dp[i][j][k] = dp[i][j][k - 1] + dp[i][j - 1][k - 1] - dp[i][j - 1][k];
                    else dp[i][j][k] = dp[i - 1][j][k] + dp[i - 1][j - 1][k] + dp[i - 1][j][k - 1] - dp[i - 1][j - 1][k - 1];
                }
            }
        }

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == -1 && b == -1 && c == -1) break;

            bw.write("w(" + a + ", " + b + ", " + c + ") = ");
            
            if(a <= 0 || b <= 0 || c <= 0) bw.write(dp[0][0][0] + "\n");
            else if (a > 20 || b > 20 || c > 20) bw.write(dp[20][20][20] + "\n");
            else bw.write(dp[a][b][c] + "\n");
        }

        bw.close();
    }
}