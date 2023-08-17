import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int n = 0; n < N; n++) arr[n] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        loop: for (int m = 0; m < M; m++) {
            int find = Integer.parseInt(st.nextToken());
            int l = 0;
            int r = N - 1;

            while (l <= r) {
                int mid = (l + r) / 2;

                if (find == arr[mid]) {
                    bw.write("1\n");
                    continue loop;
                }
                else if (arr[mid] < find) l = mid + 1;
                else if (find < arr[mid]) r = mid - 1;
            }

            bw.write("0\n");
        }
        
        bw.close();
    }
}
