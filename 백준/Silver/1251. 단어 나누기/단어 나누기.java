import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        ArrayList<String> words = new ArrayList<>();

        for(int i = 1; i < s.length() - 1; i++){
            for(int j = i + 1; j < s.length(); j++){
                StringBuffer sb1 = new StringBuffer(s.substring(0, i));
                StringBuffer sb2 = new StringBuffer(s.substring(i, j));
                StringBuffer sb3 = new StringBuffer(s.substring(j, s.length()));

                words.add(sb1.reverse().toString() + sb2.reverse().toString() + sb3.reverse().toString());
            }
        }

        words.sort(Comparator.naturalOrder());

        bw.write(words.get(0) + "\n");
        bw.flush();
        bw.close();
    }
}