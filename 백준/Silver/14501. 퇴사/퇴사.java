import java.util.*;
import java.io.*;

public class Main {
    public static int max = 0;
    public static void bruteForce(int[][] arr, int n, int idx, int total) {
        if(idx == n) {
            max = Math.max(max, total);
            return;
        }

        int next = idx + arr[idx][0];

        if(next <= n) {
            bruteForce(arr, n, next, total + arr[idx][1]);
        }

        bruteForce(arr, n, idx + 1, total);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bruteForce(arr, n, 0, 0);

        bw.write(max + "");
        bw.close();
    }
}