import java.util.*;
import java.awt.Point;

class Solution {
    public int bfs(String[] maps, Point[] p) {
        Queue<Point> queue = new LinkedList<>();
        int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int[][] visit = new int[maps.length][maps[0].length()];

        queue.add(p[0]);
        visit[p[0].x][p[0].y] = 1;

        loop: while (!queue.isEmpty()) {
            Point now = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nr = now.x + delta[i][0];
                int nc = now.y + delta[i][1];

                if(nr < 0 || nr >= maps.length || nc < 0 || nc >= maps[0].length() || maps[nr].charAt(nc) == 'X' || visit[nr][nc] != 0) continue;

                queue.add(new Point(nr, nc));
                visit[nr][nc] = visit[now.x][now.y] + 1;
                if(maps[nr].charAt(nc) == 'L') break loop;
            }
        }

        if(visit[p[1].x][p[1].y] == 0) return -1;

        int tmp = visit[p[1].x][p[1].y] - 1;
        queue = new LinkedList<>();
        visit = new int[maps.length][maps[0].length()];

        queue.add(p[1]);
        visit[p[1].x][p[1].y] = tmp;

        loop: while (!queue.isEmpty()) {
            Point now = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nr = now.x + delta[i][0];
                int nc = now.y + delta[i][1];

                if(nr < 0 || nr >= maps.length || nc < 0 || nc >= maps[0].length() || maps[nr].charAt(nc) == 'X' || visit[nr][nc] != 0) continue;

                queue.add(new Point(nr, nc));
                visit[nr][nc] = visit[now.x][now.y] + 1;
                if(maps[nr].charAt(nc) == 'E') break loop;
            }
        }

        return visit[p[2].x][p[2].y] != 0 ? visit[p[2].x][p[2].y] : -1;
    }
    public int solution(String[] maps) {
        Point[] p = new Point[3];

        for(int i = 0; i < maps.length; i++) {
            if(maps[i].contains("S")) {
                p[0] = new Point(i, maps[i].indexOf("S"));
            }
            if(maps[i].contains("L")) {
                p[1] = new Point(i, maps[i].indexOf("L"));
            }
            if(maps[i].contains("E")) {
                p[2] = new Point(i, maps[i].indexOf("E"));
            }
        }

        return bfs(maps, p);
    }
}