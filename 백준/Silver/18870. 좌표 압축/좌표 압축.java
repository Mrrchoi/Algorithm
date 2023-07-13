import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int k = 0;
        TreeSet<Integer> tree = new TreeSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            tree.add(arr[i]);
        }

        for(int value : tree) map.put(value, k++);

        for(int i = 0; i < n; i++) bw.write(map.get(arr[i]) + " ");

        bw.flush();
        bw.close();
    }
}