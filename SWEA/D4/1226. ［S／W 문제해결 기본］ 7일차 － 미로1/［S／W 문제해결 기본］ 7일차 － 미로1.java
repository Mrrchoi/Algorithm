import java.util.*;
import java.io.*;
import java.awt.Point;

public class Solution {
    public static boolean bfs(int[][] miro) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visit = new boolean[16][16];
        int[][] delta = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        queue.offer(new Point(1, 1));
        visit[1][1] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nr = now.x + delta[i][0];
                int nc = now.y + delta[i][1];

                if(nr < 0 || nr >= 16 || nc < 0 || nc >= 16 || miro[nr][nc] == 1 || visit[nr][nc]) continue;
                else if(miro[nr][nc] == 3) return true;

                queue.offer(new Point(nr, nc));
                visit[nr][nc] = true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int t = 1; t <= 10; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] miro = new int[16][16];

            for(int i = 0; i < 16; i++) {
                char[] chArr = br.readLine().toCharArray();

                for(int j = 0; j < 16; j++) {
                    miro[i][j] = chArr[j] - '0';
                }
            }

            bw.write("#" + n);

            if(bfs(miro)) bw.write(" 1\n");
            else bw.write(" 0\n");
        }

        bw.close();
    }
}