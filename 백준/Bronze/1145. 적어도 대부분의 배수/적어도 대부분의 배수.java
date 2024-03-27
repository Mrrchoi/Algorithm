import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[5];

        for(int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1;; i++) {
            int count = 0;

            for(int j = 0; j < 5; j++) {
                if (i % arr[j] == 0) {
                    count++;
                }
            }

            if(count >= 3) {
                bw.write(i + "");
                break;
            }
        }

        bw.close();
    }
}