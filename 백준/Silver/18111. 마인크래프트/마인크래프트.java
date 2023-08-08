import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[] arr = new int[N * M];

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for(int i = 0, idx = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++) {
                arr[idx] = Integer.parseInt(st.nextToken());

                if(arr[idx] > max) max = arr[idx];
                if(arr[idx] < min) min = arr[idx];

                idx++;
            }
        }

        int min_time = Integer.MAX_VALUE, height = 0;

        for(int i = max; i >= min; i--) {
            long inven = B;
            int time = 0;

            for (int j = 0; j < N * M; j++) {
                if (arr[j] == i) continue;
                else if (arr[j] < i) {
                    inven -= i - arr[j];
                    time += i - arr[j];
                } else if (arr[j] > i) {
                    inven += arr[j] - i;
                    time += (arr[j] - i) * 2;
                }
            }

            if(inven < 0) continue;

            if (time < min_time) {
                min_time = time;
                height = i;
            }
        }

        bw.write(min_time + " " + height);
        bw.close();
    }
}
