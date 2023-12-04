import java.util.*;
import java.awt.Point;

class Solution {
    public int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int bfs(int[][] land, Point p, int group_num) {
        Queue<Point> queue = new LinkedList<>();
        int count = 1;
        
        queue.add(p);
        land[p.x][p.y] = group_num;
        
        while(!queue.isEmpty()) {
            Point now = queue.poll();
            
            for(int i = 0; i < delta.length; i++) {
                int nr = now.x + delta[i][0];
                int nc = now.y + delta[i][1];
                
                if(nr < 0 || nr >= land.length || nc < 0 || nc >= land[0].length || land[nr][nc] != 1) {
                    continue;
                }
                
                queue.add(new Point(nr, nc));
                land[nr][nc] = group_num;
                count++;
            }
        }
        
        return count;
    }
    public int solution(int[][] land) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = -1, group_num = 2;
        
        for(int i = 0; i < land.length; i++) {
            for(int j = 0; j < land[i].length; j++) {
                if(land[i][j] == 1) {
                    int count = bfs(land, new Point(i, j), group_num);
                    map.put(group_num, count);
                    group_num++;
                }
            }
        }
        
        for(int i = 0; i < land[0].length; i++) {
            boolean[] visit = new boolean[group_num];
            int total = 0;
            
            for(int j = 0; j < land.length; j++) {
                if(land[j][i] != 0 && !visit[land[j][i]]) {
                    total += map.get(land[j][i]);
                    visit[land[j][i]] = true;
                }
            }
            
            max = Math.max(max, total);
        }
        
        return max;
    }
}