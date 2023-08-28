import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void bfs(int[][] arr) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Point> queue = new LinkedList<>();
        int[][] visit = new int[arr.length][arr[0].length];
        int[][] delta = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j] == 2) queue.offer(new Point(i, j));
                else if(arr[i][j] != 0) visit[i][j] = -1;
            }
        }

        while(!queue.isEmpty()){
            Point p = queue.poll();

            for(int i = 0; i < 4; i++){
                int next_r = p.x + delta[i][0];
                int next_c = p.y + delta[i][1];

                if(next_r < 0 || next_r >= arr.length || next_c < 0 || next_c >= arr[0].length || visit[next_r][next_c] != -1) continue;

                visit[next_r][next_c] = visit[p.x][p.y] + 1;
                queue.offer(new Point(next_r, next_c));
            }
        }

        for(int i = 0; i < visit.length; i++){
            for(int j = 0; j < visit[0].length; j++){
                bw.write(visit[i][j] + " ");
            }
            bw.newLine();
        }
        
        bw.close();
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(arr);
    }
}