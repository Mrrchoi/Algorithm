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

        int max = arr[0];

        for(int i = 1; i < n; i++) {
            if (arr[i - 1] >= 0) arr[i] += arr[i - 1];

            max = Math.max(max, arr[i]);
        }

        bw.write(max + "");
        bw.close();
    }
}