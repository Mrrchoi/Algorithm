import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int rank = 1;

        if(n > 0) {
            st = new StringTokenizer(br.readLine());
            int overlap = 0;

            for(int i = 0; i < n; i++) {
                int k = Integer.parseInt(st.nextToken());
                if(k > s) {
                    rank++;
                }
                else if(k == s) overlap++;
            }

            if(overlap + rank - 1 >= p) rank = -1;
        }

        bw.write(rank + "");
        bw.close();
    }
}