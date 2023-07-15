import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int max = 0, min = 9999999;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int k = Integer.parseInt(st.nextToken());
            if(k > max) max = k;
            if(k < min) min = k;
        }

        bw.write(max * min + "\n");
        bw.flush();
        bw.close();
    }
}