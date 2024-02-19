import java.io.*;
import java.util.*;

public class Main {
    public static int count = 0;
    public static void combination(int[] arr, boolean[] select, int n, int idx, int cnt) {
        if(cnt == 6) {
            for(int i = 0; i < n; i++) {
                if(select[i]) {
                    System.out.print(arr[i] + " ");
                }
            }

            System.out.println();
            return;
        }
        else if(idx == n) {
            return;
        }

        select[idx] = true;
        combination(arr, select, n, idx + 1, cnt + 1);
        select[idx] = false;
        combination(arr, select, n, idx + 1, cnt);

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            if(n == 0) {
                break;
            }

            int arr[] = new int[n];

            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            combination(arr, new boolean[n], n, 0, 0);
            System.out.println();
        }
    }
}