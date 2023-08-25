import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[][] rectangle = new int[101][101];

        for(int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int j = x1; j <= x2 - 1; j++){
                for(int k = y1; k <= y2 - 1; k++){
                    rectangle[j][k] = 1;
                }
            }
        }

        int count = 0;

        for(int i = 1; i <= 100; i++){
            for(int j = 1; j <= 100; j++){
                if(rectangle[i][j] == 1) count++;
            }
        }

        bw.write(count + "");
        bw.close();
    }
}