import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] result = new int[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            int[] arr = new int[p];
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < p; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            if(l > p) {
                result[i] = 1;
            }
            else {
                Arrays.sort(arr);
                result[i] = arr[p - l];
            }
        }

        Arrays.sort(result);

        int total = 0, count = 0;

        for(int i = 0; i < n; i++) {
            if(total + result[i] <= m) {
                total += result[i];
                count++;
            }
            else {
                break;
            }
        }

        bw.write(count + "");
        bw.close();
    }
}