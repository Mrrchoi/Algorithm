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
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int count = 0;

            if(n == 0) break;

            for(int i = n + 1; i <= 2 * n; i++) if(is_prime(i)) count++;

            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
    }
}