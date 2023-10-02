import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        long[] distance = new long[n - 1];
        long[] price = new long[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n - 1; i++) distance[i] = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) price[i] = Long.parseLong(st.nextToken());

        long fee = Long.MAX_VALUE;
        long total = 0;

        for(int i = 0; i < n - 1; i++) {
            fee = Math.min(fee, price[i]);

            total += fee * distance[i];
        }

        bw.write(total + "");
        bw.close();
    }
}