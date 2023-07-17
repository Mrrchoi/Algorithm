import java.io.*;
import java.util.*;

public class Main {
    public static int[] sorted;
    public static int count, k_v;
    public static void merge_sort(int[] arr, int k){
        sorted = new int[arr.length];
        k_v = k;
        count = 0;
        merge_sort(arr, 0, arr.length - 1);
        sorted = null;
    }
    private static void merge_sort(int[] arr, int left, int right){
        if(left >= right) return;

        int mid = (left + right) / 2;

        merge_sort(arr, left, mid);
        merge_sort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }
    public static void merge(int[] arr, int left, int mid, int right){
        int l = left, r = mid + 1;
        int idx = left;

        while(l <= mid && r <= right){
            if(arr[l] <= arr[r]){
                sorted[idx] = arr[l];
                l++;
                idx++;
            }
            else {
                sorted[idx] = arr[r];
                r++;
                idx++;
            }

            if(l > mid){
                while(r <= right){
                    sorted[idx] = arr[r];
                    r++;
                    idx++;
                }
            }
            else if(r > right){
                while(l <= mid){
                    sorted[idx] = arr[l];
                    l++;
                    idx++;
                }
            }
        }

        for(int i = left; i <=right; i++){
            arr[i] = sorted[i];
            if(++count == k_v) System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        merge_sort(arr, k);

        if(count < k) System.out.println("-1");

        bw.flush();
        bw.close();

    }
}