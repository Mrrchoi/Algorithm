class Solution {
    public int floyd(int[][] fares, int n, int s, int a, int b) {
        int[][] cost = new int[n + 1][n + 1];
        int INF = 100000000, min = Integer.MAX_VALUE;

        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                if(i != j) cost[i][j] = INF;
            }
        }

        for(int i = 0; i < fares.length; i++) {
            cost[fares[i][0]][fares[i][1]] = fares[i][2];
            cost[fares[i][1]][fares[i][0]] = fares[i][2];
        }

        for(int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (cost[i][j] > cost[i][k] + cost[k][j]) {
                        cost[i][j] = cost[i][k] + cost[k][j];
                    }
                }
            }
        }
        
        for(int i = 1; i < n + 1; i++) {
            if(cost[s][i] + cost[i][a] + cost[i][b] < min) {
                min = cost[s][i] + cost[i][a] + cost[i][b];
            }
        }

        return min;
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        return floyd(fares, n, s, a, b);
    }
}