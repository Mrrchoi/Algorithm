import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    public static List<Point> chicken;
    public static List<Point> house;
    public static int min = Integer.MAX_VALUE;

    public static void calculation(boolean[] select) {
        List<Point> open = new ArrayList<>();
        int total = 0;

        for(int i = 0; i < select.length; i++) {
            if(select[i]) open.add(chicken.get(i));
        }

        for(int i = 0; i < house.size(); i++) {
            int distance = Integer.MAX_VALUE;

            for(int j = 0; j < open.size(); j++) {
                distance = Math.min(distance, Math.abs(house.get(i).x - open.get(j).x) + Math.abs(house.get(i).y - open.get(j).y));
            }

            total += distance;
        }

        min = Math.min(min, total);
    }

    public static void combination(boolean[] select, int m, int idx, int cnt) {
        if(cnt == m) {
            calculation(select);
            return;
        }
        else if(idx == select.length) return;

        select[idx] = true;
        combination(select, m, idx + 1, cnt + 1);
        select[idx] = false;
        combination(select, m, idx + 1, cnt);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        chicken = new ArrayList<>();
        house = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int k = Integer.parseInt(st.nextToken());

                if(k == 1) house.add(new Point(i, j));
                else if(k == 2) chicken.add(new Point(i, j));
            }
        }

        combination(new boolean[chicken.size()], m, 0, 0);

        bw.write(min + "");
        bw.close();
    }
}