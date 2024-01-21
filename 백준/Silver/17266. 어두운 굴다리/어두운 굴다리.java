import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int prev = Integer.parseInt(st.nextToken()), max = prev;

        for(int i = 0; i < m - 1; i++) {
            int cur = Integer.parseInt(st.nextToken());
            max = Math.max(max, (cur - prev + 1) / 2);
            prev = cur;
        }

        max = Math.max(max, n - prev);

        bw.write(max + "");
        bw.close();
    }
}