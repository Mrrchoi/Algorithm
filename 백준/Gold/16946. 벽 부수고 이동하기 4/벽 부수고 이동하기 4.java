import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    public static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static void bfs(int[][] map, boolean[][] visit, Point root, Point start) {
        Queue<Point> queue = new LinkedList<>();
        Set<Point> set = new HashSet<>();

        int count = 1;

        queue.offer(start);
        visit[start.x][start.y] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nr = now.x + delta[i][0];
                int nc = now.y + delta[i][1];

                if(nr < 0 || nr >= map.length || nc < 0 || nc >= map[0].length || visit[nr][nc]) continue;
                else if(map[nr][nc] != 0) {
                    set.add(new Point(nr, nc));
                    continue;
                }

                queue.offer(new Point(nr, nc));
                visit[nr][nc] = true;
                count++;
            }
        }

        for(Point p : set) {
            map[p.x][p.y] += count;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        boolean[][] visit = new boolean[map.length][map[0].length];

        for(int i = 0; i < n; i++){
            char[] chArr = br.readLine().toCharArray();

            for(int j = 0; j < m; j++) map[i][j] = chArr[j] - '0';
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 0) bw.write("0");
                else {
                    for(int k = 0; k < 4; k++) {
                        int nr = i + delta[k][0];
                        int nc = j + delta[k][1];

                        if(nr < 0 || nr >= map.length || nc < 0 || nc >= map[0].length || map[nr][nc] != 0 || visit[nr][nc]) continue;

                        bfs(map, visit, new Point(i, j), new Point(nr, nc));
                    }

                    bw.write((map[i][j] % 10) + "");
                }
            }

            bw.newLine();
        }

        bw.close();
    }
}