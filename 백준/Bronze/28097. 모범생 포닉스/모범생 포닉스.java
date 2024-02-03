import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = 8 * (n - 1);

        for(int i = 0; i < n; i++) {
            total += Integer.parseInt(st.nextToken());
        }

        bw.write((total / 24) + " " + (total % 24));
        bw.close();
    }
}