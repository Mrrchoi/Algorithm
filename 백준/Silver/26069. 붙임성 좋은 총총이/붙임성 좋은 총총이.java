import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Map<String, Integer> dancer = new HashMap<String, Integer>(){{
            put("ChongChong", 0);
        }};

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String dan_1 = st.nextToken();
            String dan_2 = st.nextToken();

            if(dancer.containsKey(dan_1)) dancer.put(dan_2, 0);
            else if(dancer.containsKey(dan_2)) dancer.put(dan_1, 0);
        }

        bw.write(dancer.size() + "\n");
        bw.flush();
        bw.close();
    }
}