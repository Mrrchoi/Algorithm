import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        int k = 1;

        while(k <= n){
            int min_count = Integer.MAX_VALUE;

            for(int i = (int)Math.sqrt(k); i >= 1; i--) min_count = min_count > 1 + dp[k - i * i] ? 1 + dp[k - i * i] : min_count;

            dp[k++] = min_count;
        }

        System.out.println(dp[n]);

        sc.close();
    }
}
