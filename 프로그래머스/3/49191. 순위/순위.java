class Solution {
    public int dfs_win(boolean[][] graph, boolean[] visit, int v) {
        int count = 0;
        
        for(int i = 1; i < graph.length; i++) {
            if(!graph[v][i] || visit[i]) continue;
            
            count++;
            
            visit[i] = true;
            
            count += dfs_win(graph, visit, i);
        }
        
        return count;
    }
    public int dfs_lose(boolean[][] graph, boolean[] visit, int v) {
        int count = 0;
        
        for(int i = 1; i < graph.length; i++) {
            if(!graph[i][v] || visit[i]) continue;
            
            count++;
            
            visit[i] = true;
            
            count += dfs_lose(graph, visit, i);
        }
        
        return count;
    }
    public int solution(int n, int[][] results) {
        boolean[][] graph = new boolean[n + 1][n + 1];
        int answer = 0;
        
        for(int[] result : results) {
            graph[result[0]][result[1]] = true;
        }
        
        for(int i = 1; i < n + 1; i++) {
            int win = dfs_win(graph, new boolean[n + 1], i);
            int lose = dfs_lose(graph, new boolean[n + 1], i);
            if(win + lose == n - 1) {
                answer++;
            }
        }
        
        return answer;
    }
}