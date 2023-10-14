import java.io.*;
import java.util.*;

public class Main {
    public static void union(int[] parent, int a, int b) {
        int pa = find(parent, a);
        int pb = find(parent, b);

        if(pa > pb) parent[pa] = pb;
        else if(pa < pb) parent[pb] = pa;
    }
    public static int find(int[] parent, int x) {
        if(x != parent[x]) parent[x] = find(parent, parent[x]);

        return parent[x];
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] party = new ArrayList[m];
        boolean[] know = new boolean[n + 1];
        int[] parent = new int[n + 1];

        for(int i = 0; i < m; i++) party[i] = new ArrayList<>();
        for(int i = 1; i <= n; i++) parent[i] = i;

        st = new StringTokenizer(br.readLine());
        st.nextToken();

        while (st.hasMoreTokens()) know[Integer.parseInt(st.nextToken())] = true;

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            for(int j = 0; j < k; j++) {
                party[i].add(Integer.parseInt(st.nextToken()));
            }

            int tmp = party[i].get(0);

            for(int j = 1; j < k; j++) {
                union(parent, tmp, party[i].get(j));
            }
        }

        for(int i = 1; i <= n; i++) {
            if(know[i]) {
                know[find(parent, i)] = true;
            }
        }

        int count = 0;

        loop: for(int i = 0; i < m; i++) {
            for(int k : party[i]) {
                if(know[find(parent, k)]) continue loop;
            }
            count++;
        }
        
        bw.write(count + "");
        bw.close();
    }
}