import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {
    public static boolean bfs(ArrayList<Point> list) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[list.size()];

        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int index = queue.poll();
            Point now = list.get(index);

            for(int i = 1; i < list.size(); i++) {
                Point next = list.get(i);
                int distance = Math.abs(now.x - next.x) + Math.abs(now.y - next.y);

                if (!visited[i] && distance <= 1000) {
                    queue.add(i);
                    visited[i] = true;

                    if (i == list.size() - 1) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<Point> list = new ArrayList<>();

            for(int j = 0; j < n + 2; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                list.add(new Point(x, y));
            }

            boolean result = bfs(list);

            bw.write((result ? "happy\n" : "sad\n"));
        }

        bw.close();
    }
}