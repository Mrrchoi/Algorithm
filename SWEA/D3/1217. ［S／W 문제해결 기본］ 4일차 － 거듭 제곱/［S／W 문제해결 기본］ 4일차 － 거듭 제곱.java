import java.io.*;
import java.util.*;

public class Solution {
    public static int pow(int n, int m){
        if(m == 0) return 1;
        else return n * pow(n, m - 1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for(int t = 1; t <= 10; t++){
            br.readLine();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            bw.write("#" + t + " " + pow(n, m) + "\n");
        }

        bw.close();
    }
}