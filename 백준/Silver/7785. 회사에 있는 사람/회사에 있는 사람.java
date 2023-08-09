import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            if(st.nextToken().equals("enter")) set.add(str);
            else set.remove(str);
        }

        ArrayList<String> list = new ArrayList<>(set);

        list.sort(Comparator.reverseOrder());

        for(String str : list) bw.write(str + "\n");

        bw.flush();
        bw.close();
    }
}