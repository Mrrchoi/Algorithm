import java.util.*;
import java.io.*;
import java.awt.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int t = 1; t <= 5; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[n + 1];

            dp[0] = 0;
            dp[1] = 1;

            for(int i = 2; i <= n; i++) dp[i] = dp[i - 1] + dp[i - 2];

            bw.write(dp[n] + "\n");
        }

        bw.close();
    }
}