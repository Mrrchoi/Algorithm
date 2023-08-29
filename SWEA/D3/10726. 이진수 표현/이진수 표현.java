import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int test_case = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test_case; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int num = 0;

            for(int i = 0; i < n; i++) num = (num << 1) + 1;

            if((num & m) == num) bw.write("#" + t + " ON\n");
            else bw.write("#" + t + " OFF\n");
        }

        bw.close();
    }
}