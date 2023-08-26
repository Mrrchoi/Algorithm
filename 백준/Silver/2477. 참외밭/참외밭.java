import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int k = Integer.parseInt(br.readLine());
        int[][] arr = new int[6][2];
        int max_w = 0, max_h = 0;

        for(int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());

            if((arr[i][0] == 1 || arr[i][0] == 2) && max_w < arr[i][1]) max_w = arr[i][1];
            if((arr[i][0] == 3 || arr[i][0] == 4) && max_h < arr[i][1]) max_h = arr[i][1];
        }

        int area = max_w * max_h;

        for(int i = 0; i < 6; i++){
            if(arr[i % 6][0] == arr[(i + 2) % 6][0] && arr[(i + 1) % 6][0] == arr[(i + 3) % 6][0]) {
                area -= arr[(i + 1) % 6][1] * arr[(i + 2) % 6][1];
                break;
            }
        }

        bw.write(area * k + "\n");
        bw.close();
    }
}