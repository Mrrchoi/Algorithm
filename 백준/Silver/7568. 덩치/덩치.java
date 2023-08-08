import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        int[] dp = new int[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                if(arr[i][0] > arr[j][0] && arr[i][1] > arr[j][1]) dp[j]++;
                else if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) dp[i]++;
            }
        }

        for(int rank : dp) System.out.print((rank + 1) + " ");

    }
}