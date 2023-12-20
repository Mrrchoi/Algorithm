import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            max = Math.max(max, arr[i]);
        }

        int m = Integer.parseInt(br.readLine());
        int left = 0, right = max + 1;

        while (left < right) {
            int mid = (left + right) / 2;
            int total = 0;

            for(int i = 0; i < n; i++) {
                total += Math.min(arr[i], mid);
            }

            if(total > m) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }

        bw.write((left - 1) + "");
        bw.close();
    }
}