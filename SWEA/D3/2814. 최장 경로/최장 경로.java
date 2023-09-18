import java.util.*;
import java.io.*;

class Solution {
    static int max;
    public static void dfs(ArrayList<Integer>[] graph, boolean[] visit, int v, int count) {
        visit[v] = true;

        for(int w : graph[v]) {
            if(!visit[w]) {
                dfs(graph, visit, w, count + 1);
                visit[w] = false;
            }
        }

        if(max < count) max = count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int test_case = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test_case; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            ArrayList<Integer>[] graph = new ArrayList[n + 1];

            for(int i = 0; i < n + 1; i++) graph[i] = new ArrayList<>();

            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[x].add(y);
                graph[y].add(x);
            }

            max = 0;

            for(int i = 1; i < n + 1; i++) {
                boolean[] visit = new boolean[n + 1];
                dfs(graph, visit, i, 1);
            }

            bw.write("#" + t + " " + max + "\n");
        }

        bw.close();
    }
}