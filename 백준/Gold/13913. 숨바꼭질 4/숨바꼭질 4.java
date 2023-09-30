import java.io.*;
import java.util.*;

public class Main {
    public static void bfs(int n, int k) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        int[] visit = new int[100001];
        int[] parent = new int[100001];

        Arrays.fill(parent, -1);

        queue.offer(n);
        parent[n] = n;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            int[] arr = {now - 1, now + 1, now * 2};

            for(int i = 0; i < 3; i++) {
                if(0 <= arr[i] && arr[i] <= 100000 && arr[i] != n && visit[arr[i]] == 0) {
                    queue.offer(arr[i]);
                    visit[arr[i]] = visit[now] + 1;
                    parent[arr[i]] = now;
                }
            }
        }

        int eunji = k;

        while (eunji != parent[eunji]) {
            stack.push(eunji);
            eunji = parent[eunji];
        }

        stack.push(n);

        bw.write(visit[k] + "\n");

        while (!stack.isEmpty()) {
            bw.write(stack.pop() + " ");
        }

        bw.close();
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        bfs(n, k);
    }
}