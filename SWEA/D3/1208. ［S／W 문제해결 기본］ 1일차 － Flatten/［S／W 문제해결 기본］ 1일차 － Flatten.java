import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 10; i++){
            int dump = sc.nextInt();
            int[] box = new int[101];

            for(int j = 0; j < 100; j++) box[sc.nextInt()]++;

            int left = 0, right = 100;

            while(box[left] == 0) left++; //box[10] == 1
            while(box[right] == 0) right--;//

            for(int j = 0; j < dump; j++){
                if(right - left == 1) break;

                box[left]--;
                box[left + 1]++;

                box[right]--;
                box[right - 1]++;

                if(box[left] == 0) left++;
                if(box[right] == 0) right --;
            }

            System.out.println("#" + (i + 1) + " " + (right - left));
        }
    }
}