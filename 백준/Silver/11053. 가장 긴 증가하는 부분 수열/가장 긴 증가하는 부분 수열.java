import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());

        dp[0] = 1;

        for(int i = 1; i < n; i++){
            int max = dp[i];
            int idx = i;
            for(int j = i - 1; j >= 0; j--){
                if(a[i] > a[j] && max < dp[j]){
                    max = dp[j];
                    idx = j;
                }
            }

            dp[i] = dp[idx] + 1;
        }

        int max = 0;
        for(int i = 0; i < n; i++) max = max > dp[i] ? max : dp[i];

        System.out.println(max);
    }
}