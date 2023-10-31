import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] dp = new int[n + 1];
        int k = 2;

        while(k <= n){
            if(k % 3 == 0 && k % 2 == 0) dp[k] = 1 + Math.min(dp[k / 3], dp[k / 2]);
            else if(k % 3 == 0) dp[k] = 1 + Math.min(dp[k / 3], dp[k - 1]);
            else if(k % 2 == 0) dp[k] = 1 + Math.min(dp[k / 2], dp[k - 1]);
            else dp[k] = 1 + dp[k - 1];

            k++;
        }

        bw.write(dp[n] +"\n");

        while(n != 0) {
            bw.write(n + " ");

            if(n == 1) break;

            if(dp[n] == dp[n - 1] + 1) {
                n -= 1;
            }
            else if(n % 2 == 0 && dp[n] == dp[n / 2] + 1) {
                n /= 2;
            }
            else if(n % 3 == 0 && dp[n] == dp[n / 3] + 1) {
                n /= 3;
            }
        }

        bw.flush();
        bw.close();
    }
}