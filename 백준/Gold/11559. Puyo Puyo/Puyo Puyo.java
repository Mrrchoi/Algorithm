import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
    public static int[][] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static boolean bfs(char[][] field, boolean[][] visit, Point p) {
        Queue<Point> queue = new LinkedList<>();
        ArrayList<Point> list = new ArrayList<>();
        char ch = field[p.x][p.y];

        queue.add(p);
        list.add(p);
        visit[p.x][p.y] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for(int[] d : delta) {
                int nr = now.x + d[0];
                int nc = now.y + d[1];

                if (nr < 0 || nr >= field.length || nc < 0 || nc >= field[0].length || field[nr][nc] != ch || visit[nr][nc]) continue;

                queue.add(new Point(nr, nc));
                list.add(new Point(nr, nc));
                visit[nr][nc] = true;
            }
        }

        if (list.size() >= 4) {
            for(Point point : list) {
                field[point.x][point.y] = '.';
            }

            return true;
        }

        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[][] field = new char[12][6];
        int count = 0;

        for(int i = 0; i < field.length; i++) {
            field[i] = br.readLine().toCharArray();
        }

        while (true) {
            boolean[][] visit = new boolean[field.length][field[0].length];
            boolean isExist = false;

            for(int i = 0; i < field.length; i++) {
                for(int j = 0; j < field[0].length; j++) {
                    if(field[i][j] != '.' && !visit[i][j]) {
                        if (bfs(field, visit, new Point(i, j))) {
                            isExist = true;
                        }
                    }
                }
            }

            if(!isExist) break;

            for (int i = 0; i < field[0].length; i++) {
                int idx1 = field.length - 1, idx2 = field.length - 1;

                while (idx2 >= 0) {
                    if (field[idx2][i] == '.') idx2--;
                    else {
                        field[idx1--][i] = field[idx2--][i];
                    }
                }

                for(int j = idx1; j >= 0; j--) {
                    field[j][i] = '.';
                }

            }

            count++;
        }

        bw.write(count + "\n");
        bw.close();
    }
}