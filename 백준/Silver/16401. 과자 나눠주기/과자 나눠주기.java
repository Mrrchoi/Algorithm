import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int left = 1, right = 0;

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, arr[i]);
        }

        int result = 0;

        while(left <= right) {
            int mid = (left + right) / 2;
            int count = 0;

            for(int i = 0; i < n; i++) {
                count += arr[i] / mid;
            }

            if(count >= m) {
                left = mid + 1;
                result = Math.max(result, mid);
            }
            else {
                right = mid - 1;
            }
        }

        bw.write(result + "");
        bw.close();
    }
}