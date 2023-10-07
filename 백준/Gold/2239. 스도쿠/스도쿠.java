import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    public static ArrayList<Point> list = new ArrayList<>();
    public static boolean isOk = false;
    public static void search(int[][] sudoku, int idx) {
        if(idx == list.size()) {
            isOk = true;
            return;
        }

        boolean[] check = new boolean[10];
        int x = list.get(idx).x;
        int y = list.get(idx).y;
        int start_x = x / 3 * 3;
        int start_y = y / 3 * 3;

        for(int i = 0; i < 9; i++) {
            check[sudoku[x][i]] = true;
            check[sudoku[i][y]] = true;
        }

        for(int i = start_x; i < start_x + 3; i++) {
            for(int j = start_y; j < start_y + 3; j++) {
                check[sudoku[i][j]] = true;
            }
        }

        for(int i = 1; i < 10; i++) {
            if (!check[i]) {
                sudoku[x][y] = i;
                search(sudoku, idx + 1);
                if(isOk) return;
                sudoku[x][y] = 0;
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] sudoku = new int[9][9];

        for(int i = 0; i < 9; i++) {
            char[] chArr = br.readLine().toCharArray();

            for(int j = 0; j < 9; j++) {
                sudoku[i][j] = chArr[j] - '0';
                if(sudoku[i][j] == 0) list.add(new Point(i, j));
            }
        }

        search(sudoku, 0);

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                bw.write(sudoku[i][j] + "");
            }

            bw.newLine();
        }

        bw.close();
    }
}