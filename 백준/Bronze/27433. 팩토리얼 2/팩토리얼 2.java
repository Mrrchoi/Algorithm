import java.io.*;
import java.util.*;

public class Main {
    public static long factorial(long n){
        if(n <= 1) return 1;
        else return n * factorial(n - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        bw.write(factorial((long)n) + "\n");
        bw.flush();
        bw.close();

    }
}