import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[][] binggo = new int[5][5];
        int[] call = new int[25];

        for(int i = 0; i < 5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) binggo[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < 5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) call[5 * i + j] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < 25; i++){
            loop: for(int j = 0; j < 5; j++){
                for(int k = 0; k < 5; k++){
                    if(binggo[j][k] == call[i]){
                        binggo[j][k] = 0;
                        break loop;
                    }
                }
            }

            if(i < 11) continue;

            int count = 0, sum1 = 0, sum2 = 0;

            for(int j = 0; j < 5; j++){
                sum1 += binggo[j][j];
                sum2 += binggo[4 - j][j];
            }

            if(sum1 == 0) count++;
            if(sum2 == 0) count++;

            for(int j = 0; j < 5; j++){
                sum1 = 0;
                sum2 = 0;

                for(int k = 0; k < 5; k++){
                    sum1 += binggo[j][k];
                    sum2 += binggo[k][j];
                }

                if(sum1 == 0) count++;
                if(sum2 == 0) count++;
            }

            if(count >= 3){
                bw.write((i + 1) + "");
                break;
            }
        }
        
        bw.close();
    }
}