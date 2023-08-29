import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void bfs(int[][] arr) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Point> queue = new LinkedList<>();
        int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        queue.offer(new Point(0, 0));

        loop: while(!queue.isEmpty()){
            Point p = queue.poll();

            for(int i = 0; i < 4; i++){
                int next_x = p.x + delta[i][0];
                int next_y = p.y + delta[i][1];

                if(next_x < 0 || next_x >= arr.length || next_y < 0 || next_y >= arr[0].length || arr[next_x][next_y] != 1 || (next_x == 0 && next_y == 0)) continue;

                arr[next_x][next_y] = arr[p.x][p.y] + 1;

                if(next_x == arr.length - 1 && next_y == arr[0].length - 1){
                    bw.write(arr[next_x][next_y] + "");
                    break loop;
                }

                queue.offer(new Point(next_x, next_y));
            }
        }

        bw.close();
    }

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];

        for(int i = 0; i < n; i++){
            char[] chArr = br.readLine().toCharArray();

            for(int j = 0; j < m; j++) arr[i][j] = chArr[j] - '0';
        }

        bfs(arr);
    }
}