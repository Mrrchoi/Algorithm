import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] left = new int[n];
        int[] result = new int[n];

        for(int i = 0; i < n; i++) {
            left[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++) {
            int count = 0;

            for(int j = 0; j < n; j++) {
                if(result[j] == 0) {
                    if(++count > left[i]) {
                        result[j] = i + 1;
                        break;
                    }
                }
            }
        }

        for(int num : result) bw.write(num + " ");

        bw.close();
    }
}