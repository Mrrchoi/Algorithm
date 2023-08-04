import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BigInteger bi = new BigInteger("1");
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++) bi = bi.multiply(BigInteger.valueOf(i));

        String s = bi.toString();
        int count = 0;

        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) == '0') count++;
            else break;
        }

        System.out.println(count);
    }
}