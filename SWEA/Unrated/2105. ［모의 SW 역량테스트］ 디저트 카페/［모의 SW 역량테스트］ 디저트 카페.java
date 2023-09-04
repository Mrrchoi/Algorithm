import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int test_case = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test_case; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] dessert = new int[n][n];

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) dessert[i][j] = Integer.parseInt(st.nextToken());
            }

            int max = -1;

            for(int i = 0; i < n - 2; i++){
                for(int j = 1; j < n - 1; j++){
                    for(int k = 1;; k++){
                        if(i + k >= n - 1 || j - k < 0) break;

                        loop: for(int l = 1;; l++){
                            if(i + l >= n - 1 || j + l >= n || i + l + k >= n) break;

                            List<Integer> number = new ArrayList<>();

                            for(int m = 0; m <= l; m++){
                                int num1 = dessert[i + m][j + m];
                                int num2 = dessert[i + k + m][j - k + m];

                                if(num1 == num2 || number.contains(num1) || number.contains(num2)) continue loop;

                                number.add(num1);
                                number.add(num2);
                            }

                            for(int m = 1; m < k; m++){
                                int num1 = dessert[i + m][j -  m];
                                int num2 = dessert[i + l + m][j + l - m];

                                if(num1 == num2 || number.contains(num1) || number.contains(num2)) continue loop;

                                number.add(num1);
                                number.add(num2);
                            }

                            max = max > number.size() ? max : number.size();
                        }
                    }
                }
            }

            bw.write("#" + t + " " + max + "\n");
        }

        bw.close();
    }
}