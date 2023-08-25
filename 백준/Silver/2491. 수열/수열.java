import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            int count = 1;

            for(int j = i; j < n - 1; j++){
                if(arr[j] > arr[j + 1]) break;
                count++;
            }

            max = max > count ? max : count;

            count = 1;

            for(int j = i; j < n - 1; j++){
                if(arr[j] < arr[j + 1]) break;
                count++;
            }

            max = max > count ? max : count;
        }

        bw.write(max + "");
        bw.close();
    }
}