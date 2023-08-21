import java.util.Scanner;

public class Main {
    static int count1 = 0;
    static int count2 = 0;
    public static int fib(int n ){
        if(n == 1 || n == 2){
            count1++;
            return 1;
        }
        else return fib(n - 1) + fib(n - 2);
    }
    public static int fibonacci(int n){
        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 1;

        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            count2++;
        }

        return dp[n];
    }

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        fib(n);
        fibonacci(n);

        System.out.println(count1 + " " + count2);

    }
}