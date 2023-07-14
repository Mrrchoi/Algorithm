import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();

        HashSet<String> set = new HashSet<>();

        for(int i = 0; i < str.length(); i++){
            for(int j = 0; j < str.length() - i; j++) set.add(str.substring(j, j + i + 1));
        }

        bw.write(set.size() + "\n");
        bw.flush();
        bw.close();
    }
}