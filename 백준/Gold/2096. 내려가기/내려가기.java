import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] num = new int[2][3];
        int[][] dp = new int[2][3];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 3; j++){
                num[0][j] = dp[0][j];
                num[1][j] = dp[1][j];
            }

            for(int j = 0; j < 3; j++) {
                dp[0][j] = Integer.parseInt(st.nextToken());
                dp[1][j] = dp[0][j];
            }

            dp[0][0] += Math.max(num[0][0], num[0][1]);
            dp[0][1] += Math.max(num[0][0], Math.max(num[0][1], num[0][2]));
            dp[0][2] += Math.max(num[0][1], num[0][2]);

            dp[1][0] += Math.min(num[1][0], num[1][1]);
            dp[1][1] += Math.min(num[1][0], Math.min(num[1][1], num[1][2]));
            dp[1][2] += Math.min(num[1][1], num[1][2]);

        }

        bw.write(Math.max(dp[0][0], Math.max(dp[0][1], dp[0][2])) + " " + Math.min(dp[1][0], Math.min(dp[1][1], dp[1][2])));
        bw.close();
    }
}