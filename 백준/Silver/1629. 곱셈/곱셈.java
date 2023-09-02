import java.io.*;
import java.util.*;

public class Main {
    public static long pow(long a, long b, long c){
        if(b == 1) return a % c;
        else{
            long x = pow(a, b / 2, c) % c;

            if(b % 2 == 0) return ((x % c) * (x % c)) % c;
            else return (((x % c) * (x % c)) % c * (a % c)) % c;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());

        bw.write(pow(a, b, c) + "");

        bw.close();
    }
}