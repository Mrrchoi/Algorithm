import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int left = 0, right = arr.length - 1, count = 0;

        while (left < right) {
            if(arr[left] + arr[right] == x) {
                count++;
                left++;
                right--;
            }
            else if(arr[left] + arr[right] > x) {
                right--;
            }
            else {
                left++;
            }
        }

        bw.write(count + "");
        bw.close();
    }
}