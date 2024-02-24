import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    public static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static int count = 0;
    public static void dfs(char[][] map, boolean[][] visit, Point p, int dis, int k) {

        visit[p.x][p.y] = true;

        if(p.x == 0 && p.y == map[0].length - 1) {
            if(dis == k) {
                count++;
            }

            return;
        }

        for(int[] d : delta) {
            Point next = new Point(p.x + d[0], p.y + d[1]);

            if(next.x < 0 || next.x >= map.length || next.y < 0 || next.y >= map[0].length || visit[next.x][next.y] || map[next.x][next.y] == 'T') {
                continue;
            }

            dfs(map, visit, next, dis + 1, k);
            visit[next.x][next.y] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        char[][] map = new char[r][c];

        for(int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }

        dfs(map, new boolean[r][c], new Point(r - 1, 0), 1, k);

        bw.write(count + "");
        bw.close();
    }
}