import java.util.*;
import java.io.*;

class Solution {
    public static void union(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);

        if(a == b) return;
        else if(a < b) parent[b] = a;
        else parent[a] = b;
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
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] parent = new int[n + 1];

            for(int i = 1; i < n + 1; i++) parent[i] = i;

            bw.write("#" + t + " ");

            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int command = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if(command == 0) union(parent, a, b);
                else if(find(parent, a) == find(parent, b)) bw.write("1");
                else bw.write("0");
            }

            bw.newLine();
        }

        bw.close();
    }
}