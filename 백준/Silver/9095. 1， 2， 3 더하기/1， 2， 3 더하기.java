import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] dp = new int[11];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int j = 4; j <= 10; j++) dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];

        for(int i = 0; i < t; i++) System.out.println(dp[sc.nextInt()]);

    }
}