import java.util.*;
import java.io.*;

public class Main {
    public static int value = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long nume = factorial(n);
        long deno = (factorial(k) * factorial(n - k)) % value;

        bw.write((nume * pow(deno, value - 2)) % value + "");
        bw.close();
    }
    public static long pow(long n, int e) {
        if(e == 1) {
            return n;
        }

        long tmp = pow(n, e / 2);

        if(e % 2 == 1) return ((tmp * tmp) % value * n) % value;
        else return (tmp * tmp) % value;
    }
    public static long factorial(int n) {
        long result = 1;

        while (n > 1) {
            result = (result * n--) % value;
        }

        return result;
    }
}