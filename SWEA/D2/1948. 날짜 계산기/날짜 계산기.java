import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();
        int[] day = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for(int t = 1; t <= test_case; t++){
            int m1 = sc.nextInt();
            int d1 = sc.nextInt();
            int m2 = sc.nextInt();
            int d2 = sc.nextInt();
            int result = d2 - d1 + 1;

            for(int i = m1; i < m2; i++) result += day[i];

            System.out.println("#" + t + " " + result);
        }

    }
}