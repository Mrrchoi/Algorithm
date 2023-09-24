import java.util.*;
import java.io.*;
import java.awt.*;

class Solution {
    public static ArrayList<Point> people;
    public static ArrayList<Point> stairs;
    public static ArrayList<Integer> ladder;
    public static int time;

    public static int lunch(boolean[] visit, boolean std, int idx) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Queue<Integer> queue = new LinkedList<>();
        int time = 0;
        int man = 0;

        for(int i = 0; i < visit.length; i++){
            if(visit[i] == std) pq.offer(Math.abs(people.get(i).x - stairs.get(idx).x) + Math.abs(people.get(i).y - stairs.get(idx).y));
        }

        while (!pq.isEmpty()) {
            time++;

            while (!queue.isEmpty() && queue.peek() == time) {
                queue.poll();
                man--;
            }

            while (pq.peek() < time) {
                if(man < 3) {
                    pq.poll();

                    if(pq.isEmpty()) {
                        time += ladder.get(idx);
                        break;
                    }

                    queue.offer(time + ladder.get(idx));
                    man++;
                }
                else break;
            }
        }

        return time;
    }

    public static void combination(boolean[] visit, int x, int idx, int cnt) {
        if(cnt == x) {
            time = Math.min(time, Math.max(lunch(visit, false, 0), lunch(visit, true, 1)));
            return;
        }
        else if(idx == people.size()) return;

        visit[idx] = true;
        combination(visit, x, idx + 1, cnt + 1);
        visit[idx] = false;
        combination(visit, x, idx + 1, cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int test_case = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test_case; t++) {
            int n = Integer.parseInt(br.readLine());
            people = new ArrayList<>();
            stairs = new ArrayList<>();
            ladder = new ArrayList<>();
            time = Integer.MAX_VALUE;

            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    int k = Integer.parseInt(st.nextToken());

                    if(k == 1) people.add(new Point(i, j));
                    else if(k >= 2) {
                        stairs.add(new Point(i, j));
                        ladder.add(k);
                    }
                }
            }

            for(int i = 0; i <= people.size(); i++) {
                combination(new boolean[people.size()], i, 0, 0);
            }

            bw.write("#" + t + " " + time + "\n");
        }

        bw.close();
    }
}