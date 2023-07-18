import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int q = sc.nextInt();
        int p2 = q - p;
        int k = 2;
        
        while(k <= p2 && k <= q){
            if(p2 % k == 0 && q % k == 0){
                p2 /= k;
                q /= k;
            }
            else k++;
        }

        System.out.printf("%d %d", p2, q);
    }
}

