import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        char[][] map = new char[h][w];

        for(int i = 0; i < h; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {

                if(map[i][j] == 'c') {
                    int count = 1;

                    bw.write("0 ");

                    for(int k = j + 1; k < w; k++) {
                        if(map[i][k] == 'c') {
                            j = k - 1;
                            break;
                        }

                        bw.write((count++) + " ");

                        if(k == w - 1) {
                            j = w - 1;
                        }
                    }

                }
                else {
                    bw.write("-1 ");
                }
            }

            bw.newLine();
        }

        bw.close();
    }
}