import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static int Combination(int n, int r){
        BigInteger n_fac = new BigInteger("1");
        BigInteger r_fac = new BigInteger("1");

        for(int i = n; i > n - r; i--) n_fac = n_fac.multiply(BigInteger.valueOf(i));
        for(int i = r; i > 0; i--) r_fac = r_fac.multiply(BigInteger.valueOf(i));

        return n_fac.divide(r_fac).intValue();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            bw.write(Combination(m, n) + "\n");
        }

        bw.flush();
        bw.close();
    }
}