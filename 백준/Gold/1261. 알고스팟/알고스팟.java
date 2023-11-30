import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {
    public static int bfs(int[][] maze, int N, int M) {
        Queue<Point> queue = new LinkedList<>();
        int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int[][] visit = new int[N][M];

        for(int i = 0 ; i < N; i++) {
            Arrays.fill(visit[i], -1);
        }

        queue.add(new Point(0, 0));
        visit[0][0] = 0;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for(int i = 0; i < delta.length; i++) {
                int nr = now.x + delta[i][0];
                int nc = now.y + delta[i][1];

                if((nr >= 0 && nr < N && nc >= 0 && nc < M) && (visit[nr][nc] == -1 || visit[now.x][now.y] + maze[nr][nc] < visit[nr][nc])) {
                    queue.add(new Point(nr, nc));
                    visit[nr][nc] = visit[now.x][now.y] + maze[nr][nc];
                }
            }
        }

        return visit[N - 1][M - 1];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] maze = new int[N][M];

        for(int i = 0; i < N; i++) {
            char[] tmp = br.readLine().toCharArray();

            for(int j = 0; j < M; j++) {
                maze[i][j] = tmp[j] - '0';
            }
        }

        bw.write(bfs(maze, N, M) + "");
        bw.close();
    }
}