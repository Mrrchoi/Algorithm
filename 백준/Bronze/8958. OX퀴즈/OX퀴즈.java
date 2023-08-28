import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i = 0; i < t; i++){
            String s = sc.next();
            int sum = 0, count = 0;

            for(int j = 0; j < s.length(); j++){
                if(s.charAt(j) == 'O'){
                    count++;
                    sum += count;
                }
                else count = 0;
            }

            System.out.println(sum);
        }
    }
}