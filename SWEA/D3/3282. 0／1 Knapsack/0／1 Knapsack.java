import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int test_case = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test_case; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[][] bag = new int[n + 1][2];
            int[][] dp = new int[n + 1][k + 1];

            for(int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                bag[i][0] = Integer.parseInt(st.nextToken());
                bag[i][1] = Integer.parseInt(st.nextToken());
            }

            for(int i = 1; i < n + 1; i++) {
                for(int j = 1; j < k + 1; j++) {
                    if(j < bag[i][0]) dp[i][j] = dp[i - 1][j];
                    else dp[i][j] = Math.max(dp[i - 1][j],  bag[i][1] + dp[i - 1][j - bag[i][0]]);
                }
            }

            bw.write("#" + t + " " + dp[n][k] + "\n");
        }

        bw.close();
    }
}