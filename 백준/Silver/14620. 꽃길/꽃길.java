import java.util.*;
import java.io.*;

public class Main {
    public static int[][] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static int min = Integer.MAX_VALUE;
    public static void bruteForce(int[][] map, boolean[][] visited, int n, int idx, int total, int count) {
        if(count == 3) {
            min = Math.min(min, total);
            return;
        }

        loop: for(int i = idx; i < Math.pow(n, 2) - n; i++) {
            int r = i / n;
            int c = i % n;

            if(r == 0 || r == n - 1|| c == 0 || c == n - 1 || visited[r][c]) {
                continue;
            }

            for(int j = 0; j < 4; j++) {
                if(visited[r + delta[j][0]][c + delta[j][1]]) {
                    continue loop;
                }
            }

            for(int j = 0; j < 4; j++) {
                visited[r + delta[j][0]][c + delta[j][1]] = true;
                total += map[r + delta[j][0]][c + delta[j][1]];
            }

            bruteForce(map, visited, n, idx + 1, total + map[r][c], count + 1);

            for(int j = 0; j < 4; j++) {
                visited[r + delta[j][0]][c + delta[j][1]] = false;
                total -= map[r + delta[j][0]][c + delta[j][1]];
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bruteForce(map, new boolean[n][n], n, n + 1, 0, 0);

        bw.write(min + "");
        bw.close();
    }
}