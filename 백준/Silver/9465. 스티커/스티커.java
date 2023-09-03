import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][n];

            for(int j = 0; j < 2; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < n; k++) sticker[j][k] = Integer.parseInt(st.nextToken());
            }

            if(n >= 2){
                sticker[0][1] += sticker[1][0];
                sticker[1][1] += sticker[0][0];
            }

            for(int j = 2; j < n; j++){
                sticker[0][j] += Math.max(sticker[1][j - 1], sticker[1][j - 2]);
                sticker[1][j] += Math.max(sticker[0][j - 1], sticker[0][j - 2]);
            }

            bw.write(Math.max(sticker[0][n - 1], sticker[1][n - 1]) + "\n");
        }

        bw.close();
    }
}