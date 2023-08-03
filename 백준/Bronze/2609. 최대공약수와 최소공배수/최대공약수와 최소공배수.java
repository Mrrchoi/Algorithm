import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int k = 1, gcd = 1;

        while(n1 >= k && n2 >= k){
            if(n1 % k == 0 && n2 % k == 0) gcd = k;
            k++;
        }

        System.out.println(gcd + "\n" + n1 * n2 / gcd);
    }
}