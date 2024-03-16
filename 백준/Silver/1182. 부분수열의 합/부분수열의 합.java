import  java.io.*;
import java.util.*;

public class Main {
    public static int count;
    public static void subSet(int[] arr, int s, int idx, int total) {
        if(idx == arr.length) {
            if(total == s) {
                count++;
            }

            return;
        }

        subSet(arr, s, idx + 1, total + arr[idx]);
        subSet(arr, s, idx + 1, total);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        count = s == 0 ? -1 : 0;

        subSet(arr, s, 0, 0);

        bw.write(count + "");
        bw.close();
    }
}