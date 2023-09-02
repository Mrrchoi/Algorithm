import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    public static int[][] delta = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    public static void bfs(char[][] grid, Point start, int k){
        Queue<Point> queue = new LinkedList<>();
        char ch = grid[start.x][start.y] == 'B' ? (char)('O' + k) : (char)('X' + k);
        char std = grid[start.x][start.y];

        queue.offer(start);
        grid[start.x][start.y] = ch;

        while(!queue.isEmpty()){
            Point p = queue.poll();

            for(int i = 0; i < 4; i++){
                int next_r = p.x + delta[i][0];
                int next_c = p.y + delta[i][1];

                if(next_r < 0 || next_r >= grid.length || next_c < 0 || next_c >= grid.length || grid[next_r][next_c] != std) continue;

                queue.offer(new Point(next_r, next_c));
                grid[next_r][next_c] = ch;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        char[][] grid = new char[n][n];
        int[] count = new int[2];

        for(int i = 0; i < n; i++){
            grid[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] != 'X' && grid[i][j] != 'O'){
                    bfs(grid, new Point(i, j), 0);
                    count[0]++;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] != 'Y' && grid[i][j] != 'P'){
                    bfs(grid, new Point(i, j), 1);
                    count[1]++;
                }
            }
        }

        System.out.println(count[0] + " " + count[1]);

        bw.close();
    }
}
