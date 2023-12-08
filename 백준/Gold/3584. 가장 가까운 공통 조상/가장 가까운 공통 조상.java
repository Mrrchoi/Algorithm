import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for(int test_case = 0; test_case < t; test_case++) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<Integer>[] graph = new ArrayList[n + 1];
            int[] parent = new int[n + 1];

            for(int i = 1; i< n + 1; i++) {
                graph[i] = new ArrayList<>();
                parent[i] = i;
            }

            for(int i = 0; i < n - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                parent[w] = v;
            }

            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            ArrayList<Integer> list = new ArrayList<>();

            while (v != parent[v]) {
                list.add(v);
                v = parent[v];
            }

            int nca = v;

            while (w != parent[w]) {
                if(list.contains(w)) {
                    nca = w;
                    break;
                }

                w = parent[w];
            }

            bw.write(nca + "\n");
        }

        bw.close();
    }
}