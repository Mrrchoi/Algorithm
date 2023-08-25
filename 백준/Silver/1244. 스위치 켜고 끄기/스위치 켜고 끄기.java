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

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            if(gender == 1) {
                for(int j = number - 1; j < n; j += number) arr[j] = (arr[j] + 1) % 2;
            }
            else{
                int k = 0;

                while(number - 1 - k >= 0 && number - 1 + k < n && arr[number - 1 - k] == arr[number - 1 + k]) k++;

                for(int j = number - k; j <= number + k - 2; j++) arr[j] = (arr[j] + 1) % 2;
            }
        }

        for(int i = 1; i < n + 1; i++){
            bw.write(arr[i - 1] + " ");
            if(i % 20 == 0) bw.newLine();
        }

        bw.close();
    }
}