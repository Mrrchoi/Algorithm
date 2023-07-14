import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        String[] str = new String[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            map.put(s, i + 1);
            str[i] = s;
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            if(Character.isAlphabetic(s.charAt(0))) bw.write(map.get(s) + "\n");
            else bw.write(str[Integer.parseInt(s) - 1] + "\n");
        }

        bw.flush();
        bw.close();
    }
}