import java.util.*;
import  java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = n - 1;
        int result = 0;

        while (left < right) {
             result = Math.max(result, (right - left - 1) * Math.min(arr[left], arr[right]));

             if(arr[left] < arr[right]) {
                 left++;
             }
             else {
                 right--;
             }
        }

        bw.write(result + "");
        bw.close();
    }
}