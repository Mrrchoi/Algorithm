import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.valueOf(br.readLine());
        int[][] dot = new int[1001][1001];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            for(int j = 1000 - y1; j >= 1000 - y1 - h + 1 ; j--){
                for(int k = x1; k <= x1 + w - 1; k++){
                    dot[j][k] = i + 1;
                }
            }
        }

        for(int i = 0; i < n; i++){
            int count = 0;

            for(int j = 0; j < dot.length; j++) {
                for(int k = 0; k < dot[0].length; k++) {
                    if(dot[j][k] == i + 1) count++;
                }
            }

            bw.write(count + "\n");
        }

        bw.close();
    }
}
