import java.io.*;
import java.util.*;

public class Solution {
    public static boolean[] visit;
    public static int count;
    public static void subset(int[] arr, int idx, int k){
        if(idx == arr.length){
            int sum = 0;
            for(int i = 0; i < idx; i++){
                if(visit[i]) sum += arr[i];
            }

            if(k == sum) count++;
            return;
        }

        visit[idx] = true;
        subset(arr, idx + 1,k);
        visit[idx] = false;
        subset(arr, idx + 1,k);
    }
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int test_case = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test_case; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            visit = new boolean[n];
            count = 0;

            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

            subset(arr, 0, k);

            bw.write("#" + t + " " + count + "\n");

        }

        bw.close();
    }
}