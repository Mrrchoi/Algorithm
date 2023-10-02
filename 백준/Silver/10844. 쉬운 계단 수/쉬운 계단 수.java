import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n][10];

        for(int i = 1; i <= 9; i++) dp[0][i] = 1;

        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= 9; j++) {
                if (j == 0) dp[i][j] = dp[i - 1][1] % 1000000000;
                else if(j == 9) dp[i][j] = dp[i - 1][j - 1]  % 1000000000;
                else dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1])  % 1000000000;
            }
        }

        long total = 0;

        for(int i = 0; i < 10; i++) total += dp[n -1][i] % 1000000000;

        bw.write((total % 1000000000) + "");
        bw.close();
    }
}