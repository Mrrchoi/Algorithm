import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int total = 0;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()) - 68;

            if(k == 154) total += 50000;
            else if(k == 148) total += 10000;
            else if(k == 142) total += 5000;
            else if(k == 136) total += 1000;
        }

        bw.write(total + "");
        bw.close();
    }
}