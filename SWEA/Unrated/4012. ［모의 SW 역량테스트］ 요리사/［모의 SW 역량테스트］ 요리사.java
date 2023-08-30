import java.io.*;
import java.util.*;

public class Solution {
    public static boolean[] visit;
    public static int min;
    public static void subset(int[][] arr, int idx){
        if(idx == arr.length){
            int sum_true = 0;
            int sum_false = 0;

            for(int i = 0; i < idx - 1; i++){
                if(visit[i]) {
                    for(int j = i + 1; j < idx; j++){
                        if(visit[j]) sum_true += arr[i][j] + arr[j][i];
                    }
                }
                else{
                    for(int j = i + 1; j < idx; j++){
                        if(!visit[j]) sum_false += arr[i][j] + arr[j][i];
                    }
                }
            }

            if(min > Math.abs(sum_true - sum_false)) min = Math.abs(sum_true - sum_false);

            return;
        }

        visit[idx] = true;
        subset(arr, idx + 1);
        visit[idx] = false;
        subset(arr, idx + 1);
    }
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int test_case = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test_case; t++){
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            visit = new boolean[n];
            min = Integer.MAX_VALUE;

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) arr[i][j] = Integer.parseInt(st.nextToken());
            }

            subset(arr, 0);

            bw.write("#" + t + " " + min + "\n");
        }

        bw.close();
    }
}