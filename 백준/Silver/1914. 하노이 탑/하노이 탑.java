import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void Hanoi(int n, int a, int b, int c) throws Exception{
        if(n == 1) {
            bw.write(a + " " + c + "\n");
            return;
        }

        Hanoi(n - 1, a, c, b);

        bw.write(a + " " + c + "\n");

        Hanoi(n - 1, b, a, c);
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigInteger bi = new BigInteger("1");

        for(int i = 0; i < n; i++) bi = bi.multiply(BigInteger.valueOf(2));

        bi = bi.subtract(BigInteger.valueOf(1));

        bw.write(bi + "\n");
        if(n <= 20) Hanoi(n, 1, 2, 3);

        bw.flush();
        bw.close();
        sc.close();
    }
}

