import java.util.*;
import java.io.*;

public class Main {
    public static int bfs(int f, int s, int g, int u, int d) {
        Queue<Integer> queue = new LinkedList<>();
        int[] floor = new int[f + 1];
        int[] delta = {u, -d};

        floor[s] = 1;
        queue.add(s);
        
        if(s == g) {
            return 1;
        }

        while (!queue.isEmpty()) {
            int len = queue.size();

            for(int i = 0; i < len; i++) {
                int now = queue.poll();

                for(int j = 0; j < delta.length; j++) {
                    if(now + delta[j] > 0 && now + delta[j] <= f && floor[now + delta[j]] == 0) {
                        if(now + delta[j] == g) {
                            return floor[now] + 1;
                        }

                        floor[now + delta[j]] = floor[now] + 1;
                        queue.add(now + delta[j]);
                    }
                }
            }
        }

        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int result = bfs(f, s, g, u, d) - 1;

        bw.write(result < 0 ? "use the stairs" : result + "");
        bw.close();
    }
}