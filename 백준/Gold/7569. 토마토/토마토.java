import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    public static int bfs(int[][] arr,int n) {
        Queue<Point> queue = new LinkedList<>();
        int[][] delta = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}, {n, 0}, {-n, 0}};
        int count = 0;
        boolean zero_count = false;

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j] == 1) queue.offer(new Point(i, j));
                else if(arr[i][j] == 0) zero_count = true;
            }
        }

        if(queue.isEmpty() && zero_count) return -1;
        else if(queue.isEmpty()) return 0;

        while(!queue.isEmpty()){
            int len = queue.size();
            count++;

            for(int i = 0; i < len; i++){
                Point p = queue.poll();

                for(int j = 0; j < 6; j++){
                    int next_r = p.x + delta[j][0];
                    int next_c = p.y + delta[j][1];

                    if(next_r < 0 || next_r >= arr.length || (j < 4 && next_r < p.x / n * n) || (j < 4 && next_r >= (p.x / n + 1) * n) || next_c < 0 || next_c >= arr[0].length || arr[next_r][next_c] != 0) continue;

                    arr[next_r][next_c] = 1;
                    queue.offer(new Point(next_r, next_c));
                }
            }
        }

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j] == 0){
                    count = 0;
                    break;
                }
            }
        }

        return count - 1;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n * h][m];

        for(int i = 0; i < n * h; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(bfs(arr, n) + "");
        bw.close();
    }
}