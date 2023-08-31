import java.util.*;
import java.io.*;
import java.awt.*;

public class Main {
    public static int[][] delta = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    public static int bfs(char[][] campus){
        Queue<Point> queue = new LinkedList<>();
        int count = 0;

        loop: for(int i = 0; i < campus.length; i++){
            for(int j = 0; j < campus[i].length; j++){
                if(campus[i][j] == 'I'){
                    campus[i][j] = 'X';
                    queue.offer(new Point(i, j));
                    break loop;
                }
            }
        }

        while (!queue.isEmpty()){
            Point now = queue.poll();

            for(int j = 0; j < 4; j++){
                int next_r = now.x + delta[j][0];
                int next_c = now.y + delta[j][1];

                if(next_r < 0 || next_r >= campus.length || next_c < 0 || next_c >= campus[0].length || campus[next_r][next_c] == 'X') continue;

                if(campus[next_r][next_c] == 'P') count++;
                campus[next_r][next_c] = 'X';
                queue.offer(new Point(next_r, next_c));
            }
        }

        return count;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[][] campus = new char[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];

        for(int i = 0; i < campus.length; i++) campus[i] = br.readLine().toCharArray();

        int result = bfs(campus);

        if(result != 0) bw.write(result + "");
        else bw.write("TT");

        bw.close();
    }
}