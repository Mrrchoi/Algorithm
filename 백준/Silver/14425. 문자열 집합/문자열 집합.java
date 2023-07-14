import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int count = 0;

        HashSet<String> set1 = new HashSet<>();
        String[] str = new String[m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            set1.add(st.nextToken());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            str[i] = st.nextToken();
        }

        for(String elem : str) if(set1.contains(elem)) count++;

        bw.write(count + "\n");
        bw.flush();
        bw.close();
    }
}