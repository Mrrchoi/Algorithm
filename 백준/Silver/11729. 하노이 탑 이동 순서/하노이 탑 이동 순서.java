import java.io.*;
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

        System.out.println((int)Math.pow(2, n) - 1);
        Hanoi(n, 1, 2, 3);

        bw.flush();
        bw.close();
        sc.close();
    }
}

