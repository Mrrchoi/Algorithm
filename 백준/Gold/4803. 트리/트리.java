import java.util.*;
import java.io.*;

public class Main {
    public static boolean isNotTree;
    public static void dfs(ArrayList<Integer>[] graph, boolean[] visit, int v) {
        int count = 0;
        visit[v] = true;

        for(int u : graph[v]) {
            if (!visit[u]) {
                dfs(graph, visit, u);
            }
            else if (++count >= 2){
                isNotTree = true;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        for(int t = 1;; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if(n == 0 && m == 0) break;

            ArrayList<Integer>[] graph = new ArrayList[n + 1];

            for(int i = 1; i < n + 1; i++) {
                graph[i] = new ArrayList<>();
            }

            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph[a].add(b);
                graph[b].add(a);
            }

            boolean[] visit = new boolean[n + 1];
            int count = 0;

            for(int i = 1; i < n + 1; i++) {
                if(!visit[i]) {
                    isNotTree = false;
                    dfs(graph, visit, i);
                    if(!isNotTree) count++;
                }
            }

            bw.write("Case " + t + ": ");

            if(count == 0) bw.write("No trees.\n");
            else if(count == 1) bw.write("There is one tree.\n");
            else bw.write("A forest of " + count + " trees.\n");
        }

        bw.close();
    }
}