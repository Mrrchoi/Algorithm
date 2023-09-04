import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int test_case = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test_case; t++){
            TreeSet<Integer> set = new TreeSet<>();
            Map<Integer, Integer> map = new HashMap<>();
            int k = Integer.parseInt(br.readLine());

            for(int i = 0; i < k; i++){
                st = new StringTokenizer(br.readLine());
                char command = st.nextToken().charAt(0);
                int value = Integer.parseInt(st.nextToken());

                if(command == 'I'){
                    set.add(value);
                    map.putIfAbsent(value, 0);
                    map.put(value, map.get(value) + 1);
                }
                else if(set.size() > 0){
                    if(value == 1){
                        int max_value = set.last();

                        map.put(max_value, map.get(max_value) - 1);

                        if(map.get(max_value) == 0){
                            map.remove(max_value);
                            set.remove(max_value);
                        }
                    }
                    else{
                        int min_value = set.first();

                        map.put(min_value, map.get(min_value) - 1);

                        if(map.get(min_value) == 0){
                            map.remove(min_value);
                            set.remove(min_value);
                        }
                    }
                }
            }

            if(set.size() == 0) bw.write("EMPTY\n");
            else bw.write(set.last() + " " + set.first() + "\n");
        }

        bw.close();
    }
}