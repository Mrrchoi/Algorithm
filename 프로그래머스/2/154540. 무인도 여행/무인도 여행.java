import java.util.*;
import java.awt.Point;

class Solution {
    public int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int bfs(String[] maps, boolean[][] visit, Point start) {
        Queue<Point> queue = new LinkedList<>();
        int total = maps[start.x].charAt(start.y) - '0';
        
        queue.add(start);
        visit[start.x][start.y] = true;
        
        while(!queue.isEmpty()) {
            Point now = queue.poll();
            
            for(int i = 0; i < 4; i++) {
                int nr = now.x + delta[i][0];
                int nc = now.y + delta[i][1];
                
                if(nr < 0 || nr >= maps.length || nc < 0 || nc >= maps[0].length() || maps[nr].charAt(nc) == 'X' || visit[nr][nc]) continue;
                
                queue.add(new Point(nr, nc));
                visit[nr][nc] = true;
                total += maps[nr].charAt(nc) - '0';
            }
        }
        
        return total;
    }
    public int[] solution(String[] maps) {
        boolean[][] visit = new boolean[maps.length][maps[0].length()];
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[i].length(); j++) {
                if(maps[i].charAt(j) != 'X' && !visit[i][j]) {
                    result.add(bfs(maps, visit, new Point(i, j)));
                }
            }
        }
        
        if(result.size() == 0) {
            result.add(-1);
        }
        else {
            result.sort(Comparator.naturalOrder());
        }
        
        int[] answer = new int[result.size()];
        
        for(int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}