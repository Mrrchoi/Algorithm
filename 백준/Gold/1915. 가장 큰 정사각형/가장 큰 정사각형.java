import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[n + 1][m + 1];
        int size = 0;

        for(int i = 1; i < n + 1; i++) {
            char[] tmp = br.readLine().toCharArray();

            for(int j = 1; j < m + 1; j++) {
                matrix[i][j] = tmp[j - 1] - '0';
            }
        }

        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < m + 1; j++) {
                if(matrix[i][j] != 0) {
                    matrix[i][j] = Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i][j - 1])) + 1;

                    size = Math.max(size, matrix[i][j]);
                }
            }
        }

        bw.write((int)Math.pow(size, 2) + "");
        bw.close();
    }
}