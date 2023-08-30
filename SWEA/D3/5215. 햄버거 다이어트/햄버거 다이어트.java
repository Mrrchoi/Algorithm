import java.io.*;
import java.util.*;

public class Solution {
    public static boolean[] visit;
    public static int max;
    public static void subset(int[][] arr, int idx, int l){
        if(idx == arr.length){
            int sum_cal = 0;
            int sum_taste = 0;

            for(int i = 0; i < idx; i++){
                if(visit[i]) {
                    sum_taste += arr[i][0];
                    sum_cal += arr[i][1];
                }
            }

            if(sum_cal <= l && max < sum_taste) max = sum_taste;
            return;
        }

        visit[idx] = true;
        subset(arr, idx + 1, l);
        visit[idx] = false;
        subset(arr, idx + 1, l);
    }
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int test_case = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test_case; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][2];
            visit = new boolean[n];
            max = Integer.MIN_VALUE;

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            subset(arr, 0, l);

            bw.write("#" + t + " " + max + "\n");
        }

        bw.close();
    }
}