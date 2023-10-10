import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    public static int max = Integer.MIN_VALUE;
    public static void choose(ArrayList<Point> bishop, int[][] pick, int pidx, int idx, int std) {
        if(idx == bishop.size()) {
            max = Math.max(max, pidx);

            return;
        }

        boolean check = true;
        int k = (bishop.get(idx).x + bishop.get(idx).y) % 2;

        if(k == std) {
            for(int i = 0; i < pidx; i++) {
                if(Math.abs(pick[i][0] - bishop.get(idx).x) == Math.abs(pick[i][1] - bishop.get(idx).y)) {
                    check = false;
                    break;
                }
            }

            if(check) {
                pick[pidx][0] = bishop.get(idx).x;
                pick[pidx][1] = bishop.get(idx).y;

                choose(bishop, pick, pidx + 1,idx + 1, std);
            }
        }

        choose(bishop, pick, pidx,idx + 1, std);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];
        ArrayList<Point> bishop = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < n; j++) {
                chess[i][j] = Integer.parseInt(st.nextToken());

                if(chess[i][j] == 1) bishop.add(new Point(i, j));
            }
        }

        ArrayList<Point>[] pick = new ArrayList[2];

        for(int i = 0; i < 2; i++){
            pick[i] = new ArrayList<>();
        }

        int total = 0;

        choose(bishop, new int[50][2], 0, 0, 0);
        total += max;

        max = 0;

        choose(bishop, new int[50][2], 0, 0, 1);
        total += max;

        bw.write(total + "");
        bw.close();
    }
}