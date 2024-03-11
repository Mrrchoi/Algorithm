import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {
    public static int[][] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static int bfs(char[][] map, boolean[][] visited, int m, int n, Point p, char std) {
        Queue<Point> queue = new LinkedList<>();
        int count = 1;

        queue.add(p);
        visited[p.x][p.y] = true;

        while(!queue.isEmpty()) {
            Point now = queue.poll();

            for(int[] d : delta) {
                Point next = new Point(now.x + d[0], now.y + d[1]);

                if(next.x < 0 || next.x >= m || next.y < 0 || next.y >= n || map[next.x][next.y] != std || visited[next.x][next.y]) {
                    continue;
                }

                queue.add(next);
                visited[next.x][next.y] = true;
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] map = new char[m][n];
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int bTotal = 0, wTotal = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    int result = bfs(map, visited, m, n, new Point(i, j), map[i][j]);
                    switch (map[i][j]) {
                        case 'B':
                            bTotal += Math.pow(result, 2);
                            break;
                        case 'W':
                            wTotal += Math.pow(result, 2);
                    }
                }
            }
        }

        bw.write(wTotal + " " + bTotal);
        bw.close();
    }
}