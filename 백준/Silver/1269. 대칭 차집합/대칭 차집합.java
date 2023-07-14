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

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) set1.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) set2.add(Integer.parseInt(st.nextToken()));

        for(int elem : set1) if(!set2.contains(elem)) count++;
        for(int elem : set2) if(!set1.contains(elem)) count++;

        bw.write(count + "\n");
        bw.flush();
        bw.close();
    }
}