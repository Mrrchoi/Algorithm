import java.io.*;
import java.util.*;

public class Main {
    public static void bfs(ArrayList<Integer>[] tree) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> queue = new LinkedList<>();
        int[] parent = new int[tree.length];

        queue.offer(1);
        parent[1] = 1;

        while(!queue.isEmpty()){
            int now = queue.poll();

            for(int v : tree[now]){
                if(parent[v] == 0){
                    queue.offer(v);
                    parent[v] = now;
                }
            }
        }

        for(int i = 2; i < parent.length; i++) bw.write(parent[i] + "\n");
        bw.close();
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] tree = new ArrayList[n + 1];

        for(int i = 1; i < n + 1; i++) tree[i] = new ArrayList<>();

        for(int i = 0; i < n - 1; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            tree[v1].add(v2);
            tree[v2].add(v1);
        }

        bfs(tree);
    }
}