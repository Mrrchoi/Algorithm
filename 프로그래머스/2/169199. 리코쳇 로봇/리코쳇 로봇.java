import java.util.*;
import java.awt.Point;

class Solution {
    public int bfs(String[] board, Point robot) {
        Queue<Point> queue = new LinkedList<>();
        int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int[][] visit = new int[board.length][board[0].length()];
        
        queue.add(robot);
        visit[robot.x][robot.y] = 1;
        
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            
            for(int i = 0; i < 4; i++) {
                Point next = searching(board, now, delta[i]);
                
                if(board[next.x].charAt(next.y) == 'G') return visit[now.x][now.y];
                else if(visit[next.x][next.y] == 0) {
                    queue.add(next);
                    visit[next.x][next.y] = visit[now.x][now.y] + 1;
                }
            }
        }
        
        return -1;
    }
    public Point searching(String[] board, Point now, int[] d) {
        int r = now.x;
        int c = now.y;
        
        while(true) {
            if(r < 0 || r >= board.length || c < 0 || c >= board[0].length() || board[r].charAt(c) == 'D') {
                return new Point(r - d[0], c - d[1]);
            }
            
            r += d[0];
            c += d[1];
        }
    }
    public int solution(String[] board) {
        Point robot = new Point();
        
        for(int i = 0; i < board.length; i++) {
            if(board[i].contains("R")) {
                robot = new Point(i, board[i].indexOf("R"));
                break;
            }
        }

        return bfs(board, robot);
    }
}