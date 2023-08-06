import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i = 0; i < t; i++){
            int k = sc.nextInt();
            int n = sc.nextInt();
            int[][] dp = new int[k + 1][n + 1];

            for(int a = 1; a <= n; a++) dp[0][a] = a;

            for(int a = 1; a <= k; a++){
                for(int b = 1; b <= n; b++){
                    for(int c = 1; c <= b; c++) dp[a][b] += dp[a - 1][c];
                }
            }

            System.out.println(dp[k][n]);
        }
    }
}