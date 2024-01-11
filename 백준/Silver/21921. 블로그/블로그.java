import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0, max = 0, count = 0;

        for(int i = 1; i < x; i++) {
            sum += arr[i];
        }

        for(int i = x; i < n + 1; i++) {
            sum += arr[i] - arr[i - x];

            if(max < sum) {
                max = Math.max(max, sum);
                count = 1;
            }
            else if(max == sum) {
                count++;
            }
        }

        bw.write((max == 0 ? "SAD" : max + "\n" + count));
        bw.close();
    }
}