import java.util.*;
import java.io.*;

public class Main {
    public static void union(int[] parent, int max, int min) {
        parent[max] = min;
    }
    public static int find(int[] parent, int x) {
        if(parent[x] != x) parent[x] = find(parent, parent[x]);

        return parent[x];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] parent = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;

        int answer = 0;
        boolean first = true;

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int px = find(parent,Integer.parseInt(st.nextToken()));
            int py = find(parent, Integer.parseInt(st.nextToken()));

            if(px == py && first) {
                answer = i + 1;
                first = false;
            }
            else {
                union(parent, Math.max(px, py), Math.min(px, py));
            }
        }

        System.out.println(answer);
    }
}