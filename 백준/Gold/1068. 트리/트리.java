import java.util.*;
import java.io.*;

public class Main {
    public static int result = 0;
    public static void dfs(ArrayList<Integer>[] tree, boolean[] visit, int v) {
        visit[v] = true;

        int count = 0;

        for(int u : tree[v]) {
            if(!visit[u]) {
                dfs(tree, visit, u);
                count++;
            }
        }

        if(count == 0) result++;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int root = 0;
        ArrayList<Integer>[] tree = new ArrayList[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());

            if(parent == -1) root = i;
            else {
                tree[parent].add(i);
            }
        }

        int k = Integer.parseInt(br.readLine());
        boolean[] visit = new boolean[n];

        visit[k] = true;

        if(!visit[root]) dfs(tree, visit, root);

        bw.write(result + "");
        bw.close();
    }
}