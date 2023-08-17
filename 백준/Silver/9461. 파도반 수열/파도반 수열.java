import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        long[] P = new long[101];

        P[1] = 1;
        P[2] = 1;
        P[3] = 1;
        P[4] = 2;
        P[5] = 2;

        for(int i = 6; i <= 100; i++) P[i] = P[i - 1] + P[i - 5];

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) System.out.println(P[sc.nextInt()]);
    }
}
