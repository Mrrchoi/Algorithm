import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int test_case = Integer.parseInt(br.readLine());
        int[][] delta = {{1, -1}, {1, 1}}; //좌하향, 우하향

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
                    //우하향쪽으로 갔을 때 유효한 해를 가질 수 있는 범위로 제한
                    for(int k = 1;; k++){ // 좌측 꼭짓점 정하기
                        int left_point_r = i + delta[0][0] * k;
                        int left_point_c = j + delta[0][1] * k;

                        if(left_point_r >= n - 1 || left_point_c < 0) break;

                        loop: for(int l = 1;; l++){ //우측 꼭짓점 정하기
                            int right_point_r = i + delta[1][0] * l;
                            int right_point_c = j + delta[1][1] * l;

                            if(right_point_r >= n - 1 || right_point_c >= n || right_point_r + delta[0][0] * k >= n) break;

                            //유효한 꼭짓점 찾음
                            List<Integer> number = new ArrayList<>();

                            for(int m = 0; m <= l; m++){
                                int num1 = dessert[i + delta[1][0] * m][j + delta[1][1] * m];
                                int num2 = dessert[left_point_r + delta[1][0] * m][left_point_c + delta[1][1] * m];

                                if(num1 == num2 || number.contains(num1) || number.contains(num2)) continue loop;

                                number.add(num1);
                                number.add(num2);
                            }

                            for(int m = 1; m < k; m++){
                                int num1 = dessert[i + delta[0][0] * m][j + delta[0][1] * m];
                                int num2 = dessert[right_point_r + delta[0][0] * m][right_point_c + delta[0][1] * m];

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