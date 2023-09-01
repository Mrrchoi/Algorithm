import java.io.*;
import java.util.*;
import java.awt.Point;

public class Solution {
    public static int[][] chess;
    public static int[][] delta = {{-1, -1}, {-1, 0}, {-1, 1}};
    public static int count;
    public static int n;
    public static void n_queen(int r) {
        if(r == n){
            count++;
            return;
        }

        loop: for(int i = 0; i < n; i++){
            for(int j = 0; j < 3; j++){
                for(int k = 1;; k++){
                    int next_r = r + delta[j][0] * k;
                    int next_c = i + delta[j][1] * k;
                    
                    if(next_r < 0 || next_r >= n || next_c < 0 || next_c >= n) break;
                    else if(chess[next_r][next_c] == 1) continue loop;
                }
            }
            
            chess[r][i] = 1;
            n_queen(r + 1);
            chess[r][i] = 0;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test_case = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test_case; t++){
            n = Integer.parseInt(br.readLine());
            chess = new int[n][n];
            count = 0;

            n_queen(0);

            bw.write("#" + t + " " + count + "\n");
        }

        bw.close();
    }
}