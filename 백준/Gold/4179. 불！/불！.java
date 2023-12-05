import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {
    public static int bfs(char[][] map, ArrayList<Point> fire, Point p, int r, int c) {
        Queue<Point> queue1 = new LinkedList<>();
        Queue<Point> queue2 = new LinkedList<>();
        int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        boolean[][] visit1 = new boolean[r][c];
        boolean[][] visit2 = new boolean[r][c];
        int time = 1;

        queue1.add(p);
        visit1[p.x][p.y] = true;

        for(Point f : fire) {
            queue2.add(f);
            visit2[f.x][f.y] = true;
        }

        while (!queue1.isEmpty()) {
            int len = queue1.size();

            for(int i = 0; i < len; i++) {
                Point now = queue1.poll();

                if(map[now.x][now.y] == 'F') {
                    continue;
                }

                for(int[] d : delta) {
                    int nr = now.x + d[0];
                    int nc = now.y + d[1];

                    if(nr < 0 || nr >= r || nc < 0 || nc >= c) {
                        return time;
                    }
                    else if(map[nr][nc] == '#' ||  map[nr][nc] == 'F' || visit1[nr][nc]) {
                        continue;
                    }

                    queue1.add(new Point(nr, nc));
                    map[nr][nc] = 'J';
                    visit1[nr][nc] = true;
                }
            }

            len = queue2.size();

            for(int i = 0; i < len; i++) {
                Point now = queue2.poll();

                for(int[] d : delta) {
                    int nr = now.x + d[0];
                    int nc = now.y + d[1];

                    if(nr < 0 || nr >= r || nc < 0 || nc >= c || map[nr][nc] == '#' || visit2[nr][nc]) {
                        continue;
                    }

                    queue2.add(new Point(nr, nc));
                    map[nr][nc] = 'F';
                    visit2[nr][nc] = true;
                }
            }

            time++;
        }

        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[][] map = new char[r][c];
        Point p = new Point();
        ArrayList<Point> fire = new ArrayList<>();

        for(int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();

            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'J') {
                    p.x = i;
                    p.y = j;
                }
                else if(map[i][j] == 'F') {
                    fire.add(new Point(i, j));
                }
            }
        }

        int result = bfs(map, fire, p, r, c);

        bw.write(result == - 1 ? "IMPOSSIBLE" : result + "");
        bw.close();
    }
}