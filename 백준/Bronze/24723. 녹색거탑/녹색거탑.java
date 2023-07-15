import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] pascal = new int[n + 1][n + 1];
        pascal[0][0] = 1;

        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0 || i == j) pascal[i][j] = 1;
                else pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
            }
        }

        int sum = 0;
        for(int i = 0; i <= n; i++) sum += pascal[n][i];

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }
}