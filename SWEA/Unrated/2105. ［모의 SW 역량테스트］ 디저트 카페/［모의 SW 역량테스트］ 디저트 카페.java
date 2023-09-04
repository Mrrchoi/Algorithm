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
                        int left_point_r = i + k;
                        int left_point_c = j + - k;

                        if(left_point_r >= n - 1 || left_point_c < 0) break;

                        loop: for(int l = 1;; l++){
                            int right_point_r = i + l;
                            int right_point_c = j + l;

                            if(right_point_r >= n - 1 || right_point_c >= n || right_point_r + k >= n) break;

                            Set<Integer> number = new HashSet<>();
                            int count = 0;

                            for(int m = 0; m <= l; m++){
                                number.add(dessert[i + m][j + m]);
                                number.add(dessert[left_point_r + m][left_point_c + m]);

                                count += 2;

                                if(count != number.size()) continue loop;
                            }

                            for(int m = 1; m < k; m++){
                                number.add(dessert[i + m][j - m]);
                                number.add(dessert[right_point_r + m][right_point_c - m]);

                                count += 2;

                                if(count != number.size()) continue loop;
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