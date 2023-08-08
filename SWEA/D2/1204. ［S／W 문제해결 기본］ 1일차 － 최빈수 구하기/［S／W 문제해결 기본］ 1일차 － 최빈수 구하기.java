import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i = 0; i < t; i++){
            int test_case = sc.nextInt();
            int[] value = new int [101];

            for(int j = 0; j < 1000; j++) value[sc.nextInt()]++;

            int max = 0, idx = 0;

            for(int j =0; j < 101; j++){
                if(value[j] >= max){
                    max = value[j];
                    idx = j;
                }
            }

            System.out.println("#" + test_case + " " + idx);
        }

    }
}