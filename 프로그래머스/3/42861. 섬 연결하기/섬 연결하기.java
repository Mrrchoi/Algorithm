import java.util.*;

class Solution {
    public class Edge implements Comparable<Edge> {
        int v;
        int w;
        int cost;

        public Edge(int v, int w, int cost) {
            this.v = v;
            this.w = w;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    public void union(int[] parent, int x, int y) {
        if(x < y) parent[y] = x;
        else parent[x] = y;
    }
    public int find(int[] parent, int x) {
        if(x == parent[x]) return x;
        else return parent[x] = find(parent, parent[x]);
    }
    public int kruskal(int costs[][], int n) {
        int[] parent = new int[n];
        int total = 0;
        
        for(int i = 0; i < n; i++) parent[i] = i;
        
        for(int i = 0; i < costs.length; i++) {
            int px = find(parent, costs[i][0]);
            int py = find(parent, costs[i][1]);
            
            if(px != py) {
                union(parent, px, py);
                total += costs[i][2];
            }
        }
        
        return total;
    }
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        
        return kruskal(costs, n);
    }
}