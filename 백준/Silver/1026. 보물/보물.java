import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[2][n];
        int total = 0;

        for(int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr[i]);
        }

        for(int i = 0; i < n; i++) {
            total += arr[0][n - i - 1] * arr[1][i];
        }

        bw.write(total + "");
        bw.close();
    }
}