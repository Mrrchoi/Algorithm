import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new LinkedHashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) set1.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) set2.add(Integer.parseInt(st.nextToken()));

        for(int elem : set2){
            if(set1.contains(elem)) bw.write("1 ");
            else bw.write("0 ");
        }

        bw.flush();
        bw.close();
    }
}