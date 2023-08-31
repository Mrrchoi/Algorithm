import java.io.*;
import java.util.*;

public class Main {
    public static void dfs(int[][] graph, int[][] visit, int v){
        Stack<Integer> stack = new Stack<>();

        stack.push(v);

        while(!stack.empty()){
            int now = stack.peek();
            boolean hasNode = false;

            for(int i = 0; i < graph.length; i++){
                if(graph[now][i] == 1 && visit[v][i] == 0){
                    visit[v][i] = 1;
                    stack.push(i);
                    hasNode = true;
                    break;
                }
            }

            if(!hasNode) stack.pop();
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][n];
        int[][] visit = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < n; j++) graph[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++){
            dfs(graph, visit, i);

            for(int j = 0; j < n; j++) bw.write(visit[i][j] + " ");
            bw.newLine();
        }

        bw.close();
    }
}