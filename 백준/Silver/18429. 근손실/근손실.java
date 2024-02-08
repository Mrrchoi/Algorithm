import java.io.*;
import java.util.*;

public class Main {
    public static int count = 0;
    public static void permutation(int[] arr, int n, int depth, int k) {
        if(depth == n) {
            int total = 0;
            for(int i = 0; i < n; i++) {
                total += arr[i] - k;

                if(total < 0) return;
            }

            count++;

            return;
        }

        for(int i = depth; i < n; i++) {
            swap(arr, depth , i);

            permutation(arr, n, depth + 1, k);

            swap(arr, depth, i);
        }
    }

    public static void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        permutation(arr, n, 0, k);

        bw.write(count + "");
        bw.close();
    }
}