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
    public static int kruskal(ArrayList<int[]> edge, int N, int M) {
        int[] parent = new int[N + 1];
        int count = 0, cost = 0;

        for(int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < M; i++) {
            int[] now = edge.get(i);

            int px = find(parent, now[0]);
            int py = find(parent, now[1]);

            if(px != py) {
                union(parent, px, py);
                cost += now[2];
                count++;
            }

            if(count == N - 1) {
                break;
            }
        }

        return cost;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        ArrayList<int[]> edge = new ArrayList<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edge.add(new int[]{a, b, c});
        }

        edge.sort((o1, o2) -> o1[2] - o2[2]);

        bw.write(kruskal(edge, N, M) + "");
        bw.close();
    }
}