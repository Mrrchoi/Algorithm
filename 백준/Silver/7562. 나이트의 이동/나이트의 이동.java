import java.util.*;
import java.io.*;
import java.awt.*;

public class Main {
    public static int[][] delta = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};
    public static int bfs(Point[] dot, int l){
        Queue<Point> queue = new LinkedList<>();
        int[][] chess = new int[l][l];

        queue.offer(dot[0]);

        while (!queue.isEmpty()){
            Point now = queue.poll();

            if(dot[1].equals(now)) break;

            for(int j = 0; j < 8; j++){
                int next_r = now.x + delta[j][0];
                int next_c = now.y + delta[j][1];

                if(next_r < 0 || next_r >= l || next_c < 0 || next_c >= l || chess[next_r][next_c] != 0 || (next_r == dot[0].x && next_c == dot[0].y)) continue;

                chess[next_r][next_c] = chess[now.x][now.y] + 1;
                queue.offer(new Point(next_r, next_c));
            }
        }

        return chess[dot[1].x][dot[1].y];
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int test_case = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test_case; t++){
            int l = Integer.parseInt(br.readLine());
            Point[] dot = new Point[2];

            for(int i = 0; i < 2; i++){
                st = new StringTokenizer(br.readLine());
                dot[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            bw.write(bfs(dot, l) + "\n");
        }

        bw.close();
    }
}