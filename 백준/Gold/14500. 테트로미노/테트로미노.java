import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        int[][][] tetromino = {{{0, 0}, {1, 0}, {2, 0}, {3, 0}}, {{0, 0}, {0, 1}, {0, 2}, {0, 3}}, {{0, 0}, {0, 1}, {1, 0}, {1, 1}},
                {{0, 0}, {0, 1}, {0, 2}, {1, 1}}, {{0, 0}, {0, 1}, {0, 2}, {-1, 1}}, {{0, 0}, {1, 0}, {2, 0}, {1, -1}}, {{0, 0}, {1, 0}, {2, 0}, {1, 1}},
                {{0, 0}, {-1, 0}, {-1, 1}, {-1 ,2}}, {{0, 0}, {1, 0}, {1, 1}, {1 ,2}}, {{0, 0}, {0, 1}, {1, 1}, {2, 1}}, {{0, 0}, {0, -1}, {1, -1}, {2, -1}},
                {{0, 0}, {1, 0}, {2, 0}, {2, 1}}, {{0, 0}, {1, 0}, {2, 0}, {2, -1}}, {{0, 0}, {0, 1}, {0, 2}, {1, 2}}, {{0, 0}, {0, 1}, {0, 2}, {-1, 2}},
                {{0, 0}, {0, 1}, {-1, 1}, {-1, 2}}, {{0, 0}, {0, 1}, {1, 1}, {1, 2}}, {{0, 0}, {1, 0}, {1, 1}, {2, 1}}, {{0, 0}, {1, 0}, {1, -1}, {2, -1}}};
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                loop: for(int k = 0; k < 19; k++){
                    int sum = 0;
                    for(int l = 0; l < 4; l++){
                        if(i + tetromino[k][l][0] < 0 || i + tetromino[k][l][0] >= n || j + tetromino[k][l][1] < 0 || j + tetromino[k][l][1] >= m) continue;

                        sum += arr[i + tetromino[k][l][0]][j + tetromino[k][l][1]];
                    }

                    if(max < sum) max = sum;
                }
            }
        }

        bw.write(max + "");
        bw.close();
    }
}