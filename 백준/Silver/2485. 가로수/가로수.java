import java.io.*;
import java.util.*;

public class Main {
    public static int gcd(int a, int b){
        int n;

        while(b != 0){
            n = a % b;
            a = b;
            b = n;
        }

        return a;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n - 1];
        int count = 0;

        st = new StringTokenizer(br.readLine());
        int last = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n - 1; i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            arr[i] = k - last;
            last = k;
        }

        int gcd = gcd(Math.max(arr[0], arr[1]), Math.min(arr[0], arr[1]));

        for(int i = 2; i < n - 3; i++) gcd = gcd(Math.max(arr[i], gcd), Math.min(arr[i], gcd));

        for(int i = 0; i < n - 1; i++) if(arr[i] != gcd) count += arr[i] / gcd - 1;

        bw.write( count + "\n");
        bw.flush();
        bw.close();
    }
}