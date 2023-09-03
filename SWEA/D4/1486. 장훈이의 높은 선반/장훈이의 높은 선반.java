import java.io.*;
import java.util.*;

public class Solution {
    public static int[] source;
    public static boolean[] visit;
    public static int gap;
    public static void subset(int srcIdx, int b){
        if(srcIdx == source.length){
            int sum = -b;

            for(int i = 0; i < visit.length; i++){
                if(visit[i]) sum += source[i];
            }

            gap = sum >= 0 && sum < gap ? sum : gap;

            return;
        }
        visit[srcIdx] = true;
        subset(srcIdx + 1, b);
        visit[srcIdx] = false;
        subset(srcIdx + 1, b);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int test_case = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test_case; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            source = new int[n];
            visit = new boolean[n];
            gap = Integer.MAX_VALUE;

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) source[i] = Integer.parseInt(st.nextToken());

            subset(0, b);

            bw.write("#" + t + " " + gap + "\n");
        }

        bw.close();
    }
}