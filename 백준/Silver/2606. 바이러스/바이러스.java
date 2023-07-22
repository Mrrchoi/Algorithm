import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int[][] com;
    static int count = 0;

    public static void dfs_set(int n){
        visited = new boolean[n + 1];
        com = new int[n + 1][n + 1];
    }
    public static void dfs(int idx){
        visited[idx] = true;

        if(idx != 1) count++;

        for(int i : com[idx]){
            if(i == 0) return;

            if(!visited[i]) dfs(i);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());

        dfs_set(n);

        for(int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine());
            int idx1 = Integer.parseInt(st.nextToken());
            int idx2 = Integer.parseInt(st.nextToken());

            for(int j = 0; j < n + 1; j++) {
                if (com[idx1][j] == 0) {
                    com[idx1][j] = idx2;
                    break;
                }
            }

            for(int j = 0; j < n + 1; j++) {
                if (com[idx2][j] == 0) {
                    com[idx2][j] = idx1;
                    break;
                }
            }
        }

        dfs(1);

        bw.write(count + "");
        bw.flush();
        bw.close();
    }
}