import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int [n];
        int[][] dp = new int[2][n];

        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        dp[0][0] = 1;

        for(int i = 1; i < n; i++) {
            dp[0][i] = 1;
            for(int j = i - 1; j >= 0; j--) {
                if(arr[i] > arr[j]) dp[0][i] = Math.max(dp[0][i], dp[0][j] + 1);
            }
        }

        dp[1][n - 1] = 1;

        for(int i = n - 2; i >= 0; i--) {
            dp[1][i] = 1;
            for(int j = i + 1; j < n; j++) {
                if(arr[i] > arr[j]) dp[1][i] = Math.max(dp[1][i], dp[1][j] + 1);
            }
        }

        int max = 0;

        for(int i = 0; i < n; i++) max = Math.max(max, dp[0][i] + dp[1][i] - 1);

        bw.write(max + "");
        bw.close();
    }
}