import java.util.*;
import java.io.*;

class Solution {
    public static void union(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);

        if(a < b) parent[b] = a;
        else if(a > b) parent[a] = b;
    }

    public static int find(int[] parent, int x) {
        if(parent[x] == x) return x;
        else return parent[x] = find(parent, parent[x]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int test_case = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test_case; t++) {
            Set<Integer> set = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] parent = new int[n + 1];

            for(int i = 1; i < n + 1; i++) parent[i] = i;

            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(parent, a, b);
            }

            for(int i = 1; i < n + 1; i++) set.add(find(parent, i));

            bw.write("#" + t + " " + set.size() + "\n");
        }

        bw.close();
    }
}