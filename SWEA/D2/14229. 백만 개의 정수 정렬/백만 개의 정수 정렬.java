import java.io.*;
import java.util.*;

public class Solution {
    public static int[] sorted = new int[1000000];

    public static void merge_sort(int[] arr, int left, int right){
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
            if(arr[l] < arr[r]) sorted[idx++] = arr[l++];
            else sorted[idx++] = arr[r++];

            if(l > mid){
                while (r <= right) sorted[idx++] = arr[r++];
            }
            else if(r > right){
                while (l <= mid) sorted[idx++] = arr[l++];
            }
        }

        for(int i = left; i <= right; i++) arr[i] = sorted[i];
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[1000000];

        for(int i = 0; i < 1000000; i++) arr[i] = Integer.parseInt(st.nextToken());

        merge_sort(arr, 0, 999999);

        bw.write(arr[500000] + "");

        bw.close();
    }
}