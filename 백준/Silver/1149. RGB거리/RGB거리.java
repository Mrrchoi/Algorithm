import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] rgb = new int[n][3];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 3; j++) rgb[i][j] = Integer.parseInt(st.nextToken());

            if(i < 1) continue;

            rgb[i][0] += Math.min(rgb[i - 1][1], rgb[i -1][2]);
            rgb[i][1] += Math.min(rgb[i - 1][0], rgb[i -1][2]);
            rgb[i][2] += Math.min(rgb[i - 1][0], rgb[i -1][1]);
        }

        bw.write(Math.min(rgb[n - 1][0], Math.min(rgb[n -1][1], rgb[n - 1][2])) + "");
        bw.close();
    }
}