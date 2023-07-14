import java.io.*;
import java.util.*;

public class Main {
    public static long gcd(long a, long b){
        long n;

        while( b != 0){
            n = a % b;
            a = b;
            b = n;
        }

        return a;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long gcd = gcd(Math.max(a, b), Math.min(a, b));

        bw.write( a * b / gcd + "\n");
        bw.flush();
        bw.close();
    }
}