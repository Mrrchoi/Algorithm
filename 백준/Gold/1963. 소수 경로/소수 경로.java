import java.util.*;
import java.io.*;

public class Main {
    public static int bfs(boolean[] not_prime, int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[10000];
        int depth = 1;

        if(start == end) {
            return 0;
        }

        queue.add(start);
        visit[start] = true;

        while (!queue.isEmpty()) {
            int len = queue.size();

            for(int l = 0; l < len; l++) {
                String now = String.valueOf(queue.poll());

                for(int i = 0; i < 4; i++) {
                    for(int j = 0; j < 10; j++) {
                        if(i == 0 && j == 0) continue;

                        int num = Integer.parseInt(now.substring(0, i) + j + now.substring(i + 1, 4));

                        if(not_prime[num] || visit[num]) continue;

                        queue.add(num);
                        visit[num] = true;

                        if(num == end) {
                            return depth;
                        }
                    }
                }
            }

            depth++;
        }

        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        boolean[] not_prime = new boolean[10000];

        for(int i = 2; i < 10000; i++) {
            if(not_prime[i]) continue;

            for(int j = 2 * i; j < 10000; j += i) {
                not_prime[j] = true;
            }
        }

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int result = bfs(not_prime, start, end);

            bw.write(result == -1 ? "Impossible\n" : result + "\n");
        }

        bw.close();
    }
}