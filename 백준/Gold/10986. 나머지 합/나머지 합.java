import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        long[] remainder = new long[m];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i < n + 1; i++) {
            arr[i] = (arr[i - 1] + Integer.parseInt(st.nextToken())) % m;
            remainder[arr[i]]++;
        }

        long count = remainder[0];

        for(int i = 0; i < m; i++) {
            count += (remainder[i] * (remainder[i] - 1)) / 2;
        }

        bw.write(count + "");
        bw.close();
    }
}