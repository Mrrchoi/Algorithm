import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>(map.keySet());

        list.sort((o1, o2) -> map.get(o2) - map.get(o1));

        for(int i = 0; i < list.size(); i++) {
            int num = list.get(i);

            for(int j = 0; j < map.get(num); j++) {
                bw.write(num + " ");
            }
        }

        bw.close();
    }
}