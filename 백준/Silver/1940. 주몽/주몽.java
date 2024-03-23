import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0, right = n - 1, count = 0;

        while (left < right) {
            int total = arr[left] + arr[right];

            if(total == m) {
                count++;
                left++;
                right--;
            }
            else if (total < m) {
                left++;
            }
            else {
                right--;
            }
        }

        bw.write(count + "");
        bw.close();
    }
}