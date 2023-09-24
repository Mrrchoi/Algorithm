import java.util.*;
import java.io.*;

public class Main {

    public static void union(Map<String, String> network, Map<String, Integer> size, String s1, String s2) {
        if(s1.compareTo(s2) >= 0) {
            size.put(s2, size.get(s1) + size.get(s2));
            network.put(s1, s2);
        }
        else {
            size.put(s1, size.get(s1) + size.get(s2));
            network.put(s2, s1);
        }
    }
    public static String find(Map<String, String> network, String s) {
        if(!s.equals(network.get(s))) network.put(s, find(network, find(network, network.get(s))));

        return network.get(s);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int test_case = Integer.parseInt(br.readLine());

        for(int t = 0; t < test_case; t++) {
            int f = Integer.parseInt(br.readLine());
            Map<String, String> network = new HashMap<>();
            Map<String, Integer> size = new HashMap<>();

            for(int i = 0; i < f; i++) {
                st = new StringTokenizer(br.readLine());
                String s1 = st.nextToken();
                String s2 = st.nextToken();

                network.putIfAbsent(s1, s1);
                network.putIfAbsent(s2, s2);

                size.put(s1, size.getOrDefault(s1, 1));
                size.put(s2, size.getOrDefault(s2, 1));

                String p1 = find(network, s1);
                String p2 = find(network, s2);

                if(!p1.equals(p2)) union(network, size, p1, p2);

                bw.write(Math.max(size.get(p1), size.get(p2)) + "\n");
            }
        }

        bw.close();
    }
}