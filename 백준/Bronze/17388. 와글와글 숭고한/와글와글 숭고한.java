import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int total = s + k + h, min = Math.min(s, Math.min(k, h));

        if(total >= 100) bw.write("OK");
        else if(s == min) bw.write("Soongsil");
        else if(k == min) bw.write("Korea");
        else bw.write("Hanyang");

        bw.close();
    }
}