import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    public static int[][] delta = {{0, -1, 0}, {0, 0, 1}, {0, 1, 0}, {0, 0, -1}, {1, 0, 0}, {-1, 0, 0}};
    public static int[][][] dot = {{{0, 0, 0}, {4, 4, 4}}, {{0, 0, 4}, {4, 4, 0}}, {{0, 4, 0}, {4, 0, 4}}, {{0, 4, 4}, {4, 0, 0}}};
    public static int min = Integer.MAX_VALUE;
    public static void bfs(int[][][] miro, int[] start, int[] end) {
        Queue<int[]> queue = new LinkedList<>();
        int[][][] visit = new int[5][5][5];

        queue.add(start);
        visit[start[0]][start[1]][start[2]] = 1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for(int i = 0; i < delta.length; i++) {
                int z = now[0] + delta[i][0];
                int y = now[1] + delta[i][1];
                int x = now[2] + delta[i][2];

                if(x < 0 || x >= 5 || y < 0 || y >= 5 || z < 0 || z >= 5 || miro[z][y][x] == 0 || visit[z][y][x] != 0) continue;

                queue.add(new int[]{z, y, x});
                visit[z][y][x] = visit[now[0]][now[1]][now[2]] + 1;

                if(z == end[0] && y == end[1] && x == end[2]) {
                    min = Math.min(min, visit[z][y][x] - 1);
                    return;
                }
            }

        }
    }
    public static void permutation(int[][][] miro, int depth) {
        if(depth == miro.length) {
            for(int i = 0; i < 4; i++) {
                if(miro[dot[i][0][0]][dot[i][0][1]][dot[i][0][2]] == 1 && miro[dot[i][1][0]][dot[i][1][1]][dot[i][1][2]] == 1) {
                    bfs(miro, dot[i][0], dot[i][1]);
                }
            }

            return;
        }

        for(int i = depth; i < miro.length; i++) {
            for(int j = 0; j < 4; j++) {
                rotate(miro, i);
                swap(miro, i, depth);
                permutation(miro, depth + 1);
                swap(miro, i, depth);
            }
        }
    }
    public static void swap(int[][][] arr, int idx1, int idx2) {
        int[][] tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
    public static void rotate(int[][][] arr, int idx) {
        int[][] tmp = new int[5][5];

        for(int i = 4; i >= 0; i--) {
            for(int j = 0; j <= 4; j++) {
                tmp[4 - i][j] = arr[idx][4 - j][4 - i];
            }
        }

        arr[idx] = tmp;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[][][] miro = new int[5][5][5];

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                st = new StringTokenizer(br.readLine());

                for(int k = 0; k < 5; k++) {
                    miro[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        permutation(miro, 0);

        bw.write( (min == Integer.MAX_VALUE ? -1 : min) + "");
        bw.close();
    }
}