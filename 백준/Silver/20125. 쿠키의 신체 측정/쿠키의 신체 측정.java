import java.io.*;
import java.awt.Point;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        char[][] cookie = new char[n][n];
        Point p = new Point(0, 0);
        boolean isFirst = false;

        for(int i = 0; i < n; i++) {
            cookie[i] = br.readLine().toCharArray();

            if(!isFirst) {
                for(int j = 0; j < n; j++) {
                    if(cookie[i][j] == '*') {
                        bw.write((i + 2) + " " + (j + 1) + "\n");
                        p = new Point(i + 1, j);
                        isFirst = true;
                        break;
                    }
                }

            }
        }

        int count = 0;

        for(int j = p.y - 1; j >= 0; j--) {
            if(cookie[p.x][j] == '*') count++;
            else break;
        }

        bw.write(count + " ");

        count = 0;

        for(int j = p.y + 1; j < n; j++) {
            if(cookie[p.x][j] == '*') count++;
            else break;
        }

        bw.write(count + " ");

        count = 1;

        for(int i = p.x + 1; i < n; i++) {
            if(cookie[i + 1][p.y - 1] == '*') {
                bw.write(count + " ");

                count = 0;

                for(int j = i + 1; j < n; j++) {
                    if(cookie[j][p.y - 1] == '*') count++;
                    else break;
                }

                bw.write(count + " ");

                count = 0;

                for(int j = i + 1; j < n; j++) {
                    if(cookie[j][p.y + 1] == '*') count++;
                    else break;
                }

                bw.write(count + " ");

                break;
            }
            else {
                count++;
            }
        }

        bw.close();
    }
}