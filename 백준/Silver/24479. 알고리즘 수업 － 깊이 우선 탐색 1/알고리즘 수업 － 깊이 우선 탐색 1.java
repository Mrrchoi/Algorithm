import java.util.*;
import java.io.*;

public class Main {
    static int count = 1;

    public static void dfs(List<List<Integer>> vertex, boolean[] visit, int[] result, int start){
        visit[start] = true;

        result[start] = count++;

        for(int ver : vertex.get(start)) if(!visit[ver]) dfs(vertex, visit, result, ver);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<List<Integer>> vertex = new ArrayList<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[] result = new int[n + 1];
        boolean[] visit = new boolean[n + 1];

        for(int i = 0; i <= n; i++) vertex.add(new ArrayList<>());

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int ver_1 = Integer.parseInt(st.nextToken());
            int ver_2 = Integer.parseInt(st.nextToken());

            vertex.get(ver_1).add(ver_2);
            vertex.get(ver_2).add(ver_1);
        }

        for(int i = 0; i <= n; i++) vertex.get(i).sort(Comparator.naturalOrder());

        dfs(vertex, visit, result, r);

        for(int i = 1; i <= n; i++) bw.write(result[i] + "\n");

        bw.close();
    }
}