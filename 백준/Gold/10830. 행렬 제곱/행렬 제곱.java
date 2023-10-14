import java.io.*;
import java.util.*;

public class Main {
    public static int[][] power(int[][] matrix, long exp) {
        if(exp == 1) return matrix;

        int[][] copy = power(matrix, exp / 2);

        copy = multiply(copy, copy);

        if(exp % 2 == 1) copy = multiply(copy, matrix);

        return copy;
    }
    public static int[][] multiply(int[][] arr1, int[][] arr2) {
        int[][] result = new int[arr1.length][arr1.length];

        for(int i = 0; i < arr1.length; i++) {
            for(int j = 0; j < arr1.length; j++) {
                for(int k = 0; k < arr1.length; k++) {
                    result[i][j] += arr1[i][k] * arr2[k][j];
                    result[i][j] %= 1000;
                }
            }
        }

        return result;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        int[][] matrix = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < n; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        matrix = power(matrix, b);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                bw.write(matrix[i][j] + " ");
            }
            bw.newLine();
        }

        bw.close();
    }
}