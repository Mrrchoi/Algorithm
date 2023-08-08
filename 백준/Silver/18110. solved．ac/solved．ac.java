import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int k = (int)(n * 0.15 + 0.5);
        int sum = 0;

        for(int i = k; i < n - k; i++) sum += arr[i];

        System.out.println((int)((double)sum / (n - 2 * k) + 0.5));
    }
}