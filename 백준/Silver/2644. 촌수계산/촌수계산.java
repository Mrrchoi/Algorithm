import java.util.*;
import java.io.*;

public class Main {
    public static ArrayList<Integer>[] arr;
    public static boolean[] visited;
    
    public static void set(int n) {
        visited = new boolean[n + 1];
        arr = new ArrayList[n + 1];
        for(int i = 0; i < n + 1; i++) arr[i] = new ArrayList<Integer>();
    }
    public static void dfs(int idx, int per, int count){
        visited[idx] = true;

        count++;

        for(int i : arr[idx]) {
            if(i == per) {
                visited[i] = true;
                System.out.println(count);
                return;
            }
            if (!visited[i]) dfs(i, per, count);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int per1 = Integer.parseInt(st.nextToken());
        int per2 = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(br.readLine());

        set(n);

        for(int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine());
            int idx1 = Integer.parseInt(st.nextToken());
            int idx2 = Integer.parseInt(st.nextToken());

            arr[idx1].add(idx2);
            arr[idx2].add(idx1);
        }

        dfs(per1, per2, 0);

        if(!visited[per2]) System.out.println("-1");

    }
}