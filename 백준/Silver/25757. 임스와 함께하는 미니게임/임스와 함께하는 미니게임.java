import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<String> set = new HashSet<>();
        int n = Integer.parseInt(st.nextToken());
        String type = st.nextToken();
        int num = type.equals("Y") ? 1 : (type.equals("F") ? 2 : 3);

        for(int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        bw.write(set.size() / num + "");
        bw.close();
    }
}