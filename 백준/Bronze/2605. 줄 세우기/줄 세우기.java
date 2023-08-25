import java.io.*;
import java.util.*;

public class Main {
    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) arr[i] = i + 1;

        for(int i = 0; i < n; i++){
            int k = Integer.parseInt(st.nextToken());
            for(int j = i; j > i - k; j--){
                swap(arr, j, j -1);
            }
        }

        for(int i : arr) bw.write(i + " ");
        bw.close();
    }
}