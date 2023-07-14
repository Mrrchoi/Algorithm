import java.io.*;
import java.util.*;

public class Main {
    public static boolean is_prime(int n){
        boolean isok = true;

        if(n <= 1) return false;

        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0) {
                isok = false;
                break;
            }
        }

        return isok;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        for(int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n + 1];
            int count = 0;

            for(int j = 2; j <= n; j++){
                if(arr[j] == -1) continue;

                for(int k = j * 2; k <= n; k += j) arr[k] = -1;
            }

            for(int j = 2; j <= n / 2; j++) if(arr[j] == 0 && arr[n - j] == 0) count++;

            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
    }
}