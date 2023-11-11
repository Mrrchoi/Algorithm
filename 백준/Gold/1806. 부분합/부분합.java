import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i < n + 1; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }

        int r = n, l = n - 1, min = Integer.MAX_VALUE;

        while(r >= 0 && l >= 0) {
            if(arr[r] - arr[l] >= s) {
                min = Math.min(min, r - l);
                r--;
            }
            else {
                l--;
            }
        }

        bw.write((min != Integer.MAX_VALUE ?  min : 0) + "");
        bw.close();
    }
}