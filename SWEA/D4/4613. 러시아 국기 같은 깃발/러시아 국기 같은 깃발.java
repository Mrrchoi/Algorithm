import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int test_case = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test_case; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            char[][] chArr = new char[n][m];
            int min = Integer.MAX_VALUE;

            for(int i = 0; i < n; i++){
                chArr[i] = br.readLine().toCharArray();
            }

            for(int i = 1; i < n - 1; i++){
                int sum1 = 0;

                for(int j = 0; j < i; j++){
                    for(int k = 0; k < m; k++){
                        if(chArr[j][k] != 'W') sum1++;
                    }
                }

                for(int j = i; j < n - 1; j++){
                    int sum2 = sum1;

                    for(int k = i; k <= j; k++){
                        for(int l = 0; l < m; l++){
                            if(chArr[k][l] != 'B') sum2++;
                        }
                    }

                    for(int k = j + 1; k < n; k++){
                        for(int l = 0; l < m; l++){
                            if(chArr[k][l] != 'R') sum2++;
                        }
                    }

                    min = sum2 < min ? sum2 : min;
                }
            }

            bw.write("#" + t + " " + min + "\n");
        }

        bw.close();
    }
}