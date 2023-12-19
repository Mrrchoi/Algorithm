import java.util.*;
import java.io.*;

public class Main {
    public static int[] topoSort(ArrayList<Integer>[] graph, int[] count) {
        Queue<Integer> queue = new LinkedList<>();
        int[] sequence = new int[count.length];

        for(int i = 1; i < count.length; i++) {
            if(count[i] == 0) {
                queue.add(i);
                sequence[i] = 1;
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for(int next : graph[now]) {
                if (--count[next] == 0) {
                    queue.add(next);
                    sequence[next] = sequence[now] + 1;
                }
            }
        }

        return sequence;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        int[] count = new int[n + 1];

        for(int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());


            graph[a].add(b);
            count[b]++;
        }

        int[] sequence = topoSort(graph, count);

        for(int i = 1; i < n + 1; i++) {
            bw.write(sequence[i] + " ");
        }

        bw.close();
    }
}