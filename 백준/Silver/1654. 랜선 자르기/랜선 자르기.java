import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        long[] len = new long[k];
        long max = 0;

        for(int i = 0; i < k; i++){
            len[i] = sc.nextInt();
            if(max < len[i]) max = len[i];
        }

        long start = 0, end = max + 1;

        while(start < end){
            long mid = (start + end) / 2;
            int sum = 0;

            for(long value : len) sum += value / mid;

            if(sum < n) end = mid;
            else start = mid + 1;
        }

        System.out.println(start - 1);
    }
}