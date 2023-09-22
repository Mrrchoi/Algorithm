import java.util.*;
import java.io.*;

public class Main {
    static long[] factorial;
    static boolean[] check;

    public static void find_1(int n, long k) {
        for(int i = 0; i < n; i++) {
            for(int j = 1; j <= n; j++) {
                if (check[j]) continue;

                if(factorial[n - i - 1] < k) {
                    k -= factorial[n - i - 1];
                }
                else {
                    System.out.print(j + " ");
                    check[j] = true;
                    break;
                }
            }
        }
    }

    public static void find_2(int[] arr) {
        long total = 1;

        for(int i = 0; i < arr.length; i++) {
            for(int j = 1; j < arr[i]; j++) {
                if(!check[j]) total += factorial[arr.length - i - 1];
            }

            check[arr[i]] = true;
        }

        System.out.println(total);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int order = Integer.parseInt(st.nextToken());

        check = new boolean[n + 1];

        factorial = new long[n + 1];
        factorial[0] = factorial[1] = 1;
        for(int i = 2; i <= n; i++) factorial[i] = factorial[i - 1] * i;

        if(order == 1) {
            find_1(n, Long.parseLong(st.nextToken()));
        }
        else {
            int[] arr = new int[n];

            for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

            find_2(arr);
        }

    }
}