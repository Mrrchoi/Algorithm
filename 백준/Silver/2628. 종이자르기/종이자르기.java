import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] dot = new int[n][m];

        int k = Integer.parseInt(br.readLine());
        int[][] xy = new int[2][k + 2];

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            xy[Integer.parseInt(st.nextToken())][i] = Integer.parseInt(st.nextToken());
        }

        xy[0][k] = 0;
        xy[0][k + 1] = n;
        xy[1][k] = 0;
        xy[1][k + 1] = m;

        Arrays.sort(xy[0]);
        Arrays.sort(xy[1]);

        int max = 0;

        for(int i = 0; i < k + 1; i++){
            for(int j = 0; j < k + 1; j++){
                int area = (xy[0][i + 1] - xy[0][i]) * (xy[1][j + 1] - xy[1][j]);
                if(area > max) max = area;
            }
        }

        bw.write(max + "");
        bw.close();
    }
}
