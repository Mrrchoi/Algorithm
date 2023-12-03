import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void floyd(int[][] sequence, int n) {
        for(int k = 1; k < n + 1; k++) {
            for(int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if(sequence[i][k] == 1 && sequence[k][j] == 1) {
                        sequence[i][j] = 1;
                        sequence[j][i] = -1;
                    }
                    else if(sequence[i][k] == -1 && sequence[k][j] == -1) {
                        sequence[i][j] = -1;
                        sequence[j][i] = 1;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        int[][] sequence = new int[n + 1][n + 1];
        boolean[] visit = new boolean[n + 1];

        for(int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[v].add(w);
            sequence[v][w] = -1;
            sequence[w][v] = 1;
        }

        floyd(sequence, n);

        int s = Integer.parseInt(br.readLine());

        for(int i = 0; i < s; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            bw.write(sequence[v][w] + "\n");

        }
        bw.close();
    }
}