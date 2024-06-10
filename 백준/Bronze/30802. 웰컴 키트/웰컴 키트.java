import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[6];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int total = 0;

        for (int i = 0; i < arr.length; i++) {
            total += arr[i] / t + (arr[i] % t != 0 ? 1 : 0);
        }

        bw.write(total + "\n");
        bw.write(n / p + " " + n % p);

        bw.close();
    }
}