import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Set<String> user = new HashSet<>();
        int count = 0;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            if(s.equals("ENTER")){
                count += user.size();
                user.clear();
                continue;
            }

            user.add(s);

            if(i == n - 1) count += user.size();
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
    }
}