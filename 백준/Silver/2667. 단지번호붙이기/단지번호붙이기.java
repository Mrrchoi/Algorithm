import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
    public static List<Integer> group_size = new ArrayList<>();
    public static int count = 0;
    public static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static void bfs(int[][] village, Point p){
        Queue<Point> queue = new LinkedList<>();
        int size = 0;

        queue.add(p);
        village[p.x][p.y] = 0;

        while (!queue.isEmpty()){
            Point now = queue.poll();

            size++;

            for(int i = 0; i < 4; i++){
                int next_r = now.x + delta[i][0];
                int next_c = now.y + delta[i][1];

                if(next_r < 0 || next_r >= village.length || next_c < 0 || next_c >= village.length || village[next_r][next_c] == 0) continue;

                village[next_r][next_c] = 0;
                queue.add(new Point(next_r, next_c));
            }
        }

        group_size.add(size);
    }

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] village = new int[n][n];

        for(int i = 0; i < n; i++){
            char[] chArr = br.readLine().toCharArray();

            for(int j = 0; j < n; j++) village[i][j] = chArr[j] - '0';
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(village[i][j] == 1){
                    count++;
                    bfs(village, new Point(i, j));
                }
            }
        }

        group_size.sort(Comparator.naturalOrder());

        bw.write(count + "\n");
        for(int size : group_size) bw.write(size + "\n");
        bw.close();
    }
}