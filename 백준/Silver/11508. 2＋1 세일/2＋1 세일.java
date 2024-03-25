import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int total = 0;

        for(int i = n - 1;;) {
            if(i - 2 >= 0) {
                total += arr[i] + arr[i - 1];
                i -= 3;
            }
            else {
                for(int j = i; j >= 0; j--) {
                    total += arr[j];
                }
                break;
            }
        }

        bw.write(total + "");
        bw.close();
    }
}