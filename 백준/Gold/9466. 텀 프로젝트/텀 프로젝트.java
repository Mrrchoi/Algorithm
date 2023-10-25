import java.io.*;
import java.util.*;

public class Main {
    public static int dfs(int[] arr, boolean[] visit, int start) {
        Map<Integer, Integer> map = new HashMap<>();
        int now = start;

        map.put(now, 0);

        while (true) {
            visit[now] = true;

            if(map.getOrDefault(arr[now], -1) != -1) {
                return map.get(now) - map.get(arr[now]) + 1;
            }
            else if(visit[arr[now]]) return 0;

            map.put(arr[now], map.get(now) + 1);

            now = arr[now];
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int test_case = Integer.parseInt(br.readLine());

        for(int t = 0; t < test_case; t++) {
            int n = Integer.parseInt(br.readLine());
            boolean[] visit = new boolean[n + 1];
            int[] arr = new int[n + 1];

            st = new StringTokenizer(br.readLine());

            for(int i = 1; i < n + 1; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int count = n;

            for(int i = 1; i < n + 1; i++) {
                if(!visit[i]) {
                    count -= dfs(arr, visit, i);
                }
            }

            bw.write(count + "\n");
        }

        bw.close();
    }
}