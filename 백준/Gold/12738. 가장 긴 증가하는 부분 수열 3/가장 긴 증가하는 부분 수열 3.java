import java.util.*;
import java.io.*;

public class Main {
    public static int binarySearch(int[] lis, int start, int end, int target) {
        while (start < end) {
            int mid = (start + end) / 2;

            if(lis[mid] >= target) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }

        return end;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] lis = new int[n];
        int idx = 0;

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        lis[0] = arr[0];

        for(int i = 1; i < n; i++) {
            if(lis[idx] < arr[i]) {
                lis[++idx] = arr[i];
            }
            else {
                int new_idx = binarySearch(lis, 0, idx, arr[i]);
                lis[new_idx] = arr[i];
            }
        }

        bw.write((idx + 1) + "");
        bw.close();
    }
}