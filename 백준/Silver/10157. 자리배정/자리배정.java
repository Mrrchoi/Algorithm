import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        if(n * m < k){
            bw.write("0");
            bw.close();
            System.exit(0);
        }

        int[][] arr = new int[m][n];
        int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int r = m - 1, c = 0, turn = 0;

        for(int i = 1; i < k; i++){
            arr[r][c] = i;

            int next_r = r + delta[turn % 4][0];
            int next_c = c + delta[turn % 4][1];

            if(next_r < 0 || next_r >= m || next_c < 0 || next_c >= n || arr[next_r][next_c] != 0) turn++;

            r += delta[turn % 4][0];
            c += delta[turn % 4][1];
        }

        bw.write((c + 1) + " " + (m - r));
        bw.close();
    }
}