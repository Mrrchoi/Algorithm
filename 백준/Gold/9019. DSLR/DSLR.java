import java.io.*;
import java.util.*;

public class Main {
    public static String bfs(int a, int b) {
        Queue<Integer> queue = new LinkedList<>();
        StringBuffer[] visit = new StringBuffer[10000];
        String[] alpha = {"D", "S", "L", "R"};

        queue.offer(a);
        visit[a] = new StringBuffer();

        while (!queue.isEmpty() && visit[b] == null) {
            int now = queue.poll();

            int[] value = {(now * 2) % 10000, now != 0 ? now - 1 : 9999, (now % 1000) * 10 + now / 1000, (now % 10) * 1000 + now / 10};

            for (int i = 0; i < 4; i++) {
                if (visit[value[i]] == null) {
                    visit[value[i]] = new StringBuffer().append(visit[now]).append(alpha[i]);
                    queue.offer(value[i]);
                }
            }
        }

        return visit[b].toString();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bw.write(bfs(a, b) + "\n");
        }

        bw.close();
    }
}
