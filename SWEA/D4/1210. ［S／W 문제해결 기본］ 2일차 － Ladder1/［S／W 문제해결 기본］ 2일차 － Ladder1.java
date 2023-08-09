import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for(int i = 0; i < 10; i++){
            int t = Integer.parseInt(br.readLine());
            int[][] ladder = new int[100][100];

            for(int j = 0; j < 100; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < 100; k++){
                    ladder[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            for(int j = 0; j < 100; j++){
                if(ladder[0][j] == 0) continue;

                int x = j, y = 0;

                while(y < 100){
                    if(x < 99 && ladder[y][x + 1] == 1) while(x < 99 && ladder[y][x + 1] == 1) x++;
                    else if(x > 0 && ladder[y][x - 1] == 1) while(x > 0 && ladder[y][x - 1] == 1) x--;

                    y++;
                }

                if(ladder[y - 1][x] == 2){
                    bw.write("#" + t + " " + j + "\n");
                    break;
                }
            }
        }

        bw.close();
    }
}