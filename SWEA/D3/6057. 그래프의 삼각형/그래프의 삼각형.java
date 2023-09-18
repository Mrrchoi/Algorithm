import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int test_case = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test_case; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            ArrayList<Integer>[] graph = new ArrayList[n + 1];
            int count = 0;

            for(int i = 0; i < n + 1; i++) graph[i] = new ArrayList<>();

            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[x].add(y);
                graph[y].add(x);
            }

            for(int i = 1; i < n - 1; i++) {
                for(int v1 : graph[i]) {
                    if(v1 < i) continue;

                    for(int v2 : graph[v1]) {
                        if(v2 < v1) continue;

                        for(int v3 : graph[v2]) {
                            if(v3 == i) count++;
                        }
                    }
                }
            }

            bw.write("#" + t + " " + count + "\n");
        }

        bw.close();
    }
}