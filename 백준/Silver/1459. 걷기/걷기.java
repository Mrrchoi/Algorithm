import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Integer.parseInt(st.nextToken());
        long y = Integer.parseInt(st.nextToken());
        long w = Integer.parseInt(st.nextToken());
        long s = Integer.parseInt(st.nextToken());

        bw.write((2 * w > s ? Math.min(x, y) * s + (w > s ? (Math.max(x, y) - Math.min(x, y)) / 2 * 2 * s +  (Math.max(x, y) - Math.min(x, y)) % 2 * w: (Math.max(x, y) - Math.min(x, y)) * w) : (x + y) * w) + "");
        bw.close();
    }
}