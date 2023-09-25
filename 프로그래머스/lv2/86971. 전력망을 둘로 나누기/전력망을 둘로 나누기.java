import java.util.*;

class Solution {
    public int bfs(ArrayList<Integer>[] graph, int start, int exception) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[graph.length];
        int cnt = 1;

        queue.offer(start);

        visit[start] = true;
        visit[exception] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for(int v: graph[now]) {
                if(!visit[v]) {
                    queue.offer(v);
                    visit[v] = true;
                    cnt++;
                }
            }

        }

        return cnt;
    }
    public int solution(int n, int[][] wires) {
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        int answer = Integer.MAX_VALUE;

        for(int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for(int[] wire : wires) {
            graph[wire[0]].add(wire[1]);
            graph[wire[1]].add(wire[0]);
        }

        for(int[] wire : wires) {
            int k = bfs(graph, wire[0], wire[1]);

            answer = Math.min(answer, Math.abs(n - 2 * k));
        }

        return answer;
    }
}