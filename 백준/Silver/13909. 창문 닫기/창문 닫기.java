import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int count = 0;

        for(int i = 1; i <= n; i++) {
            if (i * i <= n) count++;
            else break;
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
    }
}