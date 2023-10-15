import java.io.*;
import java.util.*;

public class Main {
    public static long[][] power(long[][] matrix, long exp) {
        if(exp <= 1) return matrix;

        long[][] copy = power(matrix, exp / 2);

        copy = multiply(copy, copy);

        if(exp % 2 == 1) copy = multiply(copy, matrix);

        return copy;
    }
    public static long[][] multiply(long[][] o1, long[][] o2){
        long[][] result = new long[2][2];

        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                for(int k = 0; k < 2; k++) {
                    result[j][k] += o1[j][i] * o2[i][k];
                    result[j][k] %= 1000000007;
                }
            }
        }

        return result;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long[][] matrix = {{1, 1}, {1, 0}};
        long n = Long.parseLong(br.readLine());

        bw.write(power(matrix, n - 1)[0][0] + "");
        bw.close();
    }
}