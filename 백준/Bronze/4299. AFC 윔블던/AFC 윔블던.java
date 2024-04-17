import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (n < k || (n + k) % 2 != 0) {
            bw.write("-1");
        }
        else {
            int big = (n + k) / 2;
            bw.write(big + " " + (n - big));
        }

        bw.close();
    }
}