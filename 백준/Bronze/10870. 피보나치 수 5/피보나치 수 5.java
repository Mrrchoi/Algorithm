import java.io.*;
import java.util.*;

public class Main {
    public static long fibonacci(long n){
        if(n <= 1) return n;
        else return fibonacci(n - 1) +  fibonacci(n - 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        bw.write(fibonacci((long)n) + "\n");
        bw.flush();
        bw.close();
    }
}