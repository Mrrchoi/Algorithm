import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int total1 = 0, total2 = 0;


        for(int i = 0; i < 4; i++) {
            total1 += Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            total2 += Integer.parseInt(st.nextToken());
        }

        bw.write(Math.max(total1, total2) + "");
        bw.close();
    }
}