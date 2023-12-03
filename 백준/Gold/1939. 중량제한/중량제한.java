import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void union(int[] parent, int x, int y) {
        if(x > y) parent[x] = y;
        else parent[y] = x;
    }
    public static int find(int[] parent, int x) {
        if(x == parent[x]) return x;
        else return parent[x] = find(parent, parent[x]);
    }
    public static int kruskal(ArrayList<int[]> Edges, int n, int v, int w) {
        int[] parent = new int[n + 1];

        for(int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }

        Edges.sort((o1, o2) -> o2[2] - o1[2]);

        for(int i = 0; i < Edges.size(); i++) {
            int[] tmp = Edges.get(i);
            int px = find(parent, tmp[0]);
            int py = find(parent, tmp[1]);

            if(px != py) {
                union(parent, px, py);
            }

            if(find(parent, v) == find(parent, w)) {
                return tmp[2];
            }
        }

        return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<int[]> Edges = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            Edges.add(new int[]{a, b, c});
        }

        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        bw.write(kruskal(Edges, n, v, w) + "");
        bw.close();
    }
}