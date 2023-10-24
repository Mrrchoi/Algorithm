import java.io.*;
import java.util.*;

public class Main {
    public static void topo_Sort(ArrayList<Integer>[] graph, int[] count) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 1; i < count.length; i++) {
            if(count[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();

            list.add(now);

            for(int next : graph[now]) {
                if(--count[next] == 0) {
                    queue.add(next);
                }
            }
        }

        if(list.size() != graph.length - 1) bw.write("0");
        else {
            for(int num : list) {
                bw.write(num + "\n");
            }
        }

        bw.close();
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        int[] count = new int[n + 1];

        for(int i = 1; i < n + 1; i++) graph[i] = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int[] arr = new int[k];

            for(int j = 0; j < k; j++) arr[j] = Integer.parseInt(st.nextToken());

            for(int j = 0; j < k - 1; j++) {
                graph[arr[j]].add(arr[j + 1]);
                count[arr[j + 1]]++;
            }
        }

        topo_Sort(graph, count);
    }
}