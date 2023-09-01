import java.io.*;
import java.util.*;

public class Main {
    public static int Euclidean(int a, int b){
        if(b == 0) return a;
        else return Euclidean(b, a % b);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        loop: for(int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int max = m * n / Euclidean(m, n);

            for(int j = x; j <= max; j += m){
                if(j % n == y % n){
                    bw.write(j + "\n");
                    continue loop;
                }
            }

            bw.write("-1\n");

        }

        bw.close();
    }
}