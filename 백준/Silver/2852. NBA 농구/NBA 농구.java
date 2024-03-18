import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] result = new int[2][2];
        int[] count = new int[2];
        int[] last = new int[2];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            String[] time = st.nextToken().split(":");
            int total =  (Integer.parseInt(time[0]) - last[0]) * 60 + (Integer.parseInt(time[1]) - last[1]);

            if(count[0] > count[1]) {
                result[0][0] += total / 60;
                result[0][1] += total % 60;
            }
            else if(count[1] > count[0]) {
                result[1][0] += total / 60;
                result[1][1] += total % 60;
            }

            for(int j = 0; j < 2; j++) {
                last[j] = Integer.parseInt(time[j]);
            }

            count[num]++;
        }

        int total =  (48 - last[0]) * 60  - last[1];

        if(count[0] > count[1]) {
            result[0][0] += total / 60;
            result[0][1] += total % 60;
        }
        else if(count[1] > count[0]) {
            result[1][0] += total / 60;
            result[1][1] += total % 60;
        }

        for(int i = 0; i < 2; i++) {
            System.out.printf("%02d:%02d\n", result[i][0] + result[i][1] / 60, result[i][1] % 60);
        }
    }
}