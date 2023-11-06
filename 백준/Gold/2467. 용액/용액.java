import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] answer = new int[2];
        int left = 0, right = n - 1, min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        while (left < right) {
            int sum = arr[left] + arr[right];

            if(Math.abs(sum) < min) {
                min = Math.abs(sum);
                answer = new int[]{arr[left], arr[right]};
            }

            if (sum >= 0) {
                right--;
            }
            else {
                left++;
            }
        }

        bw.write(answer[0] + " " + answer[1]);
        bw.close();
    }
}