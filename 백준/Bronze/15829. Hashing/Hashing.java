import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int result = 0;

        for(int i = 0; i < s.length(); i++){
            int value = 1;

            for(int j = 0; j < i; j++){
                value *= 31;
                value %= 1234567891;
            }

            result += (s.charAt(i) - 'a' + 1) * value;
            result %= 1234567891;
        }

        System.out.println(result);
    }
}
