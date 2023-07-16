import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        int sum = 0, avg = 0;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            list.add(k);
            sum += k;
        }

        avg = sum < 0 ? (int)((double)sum / n - 0.5) : (int)((double)sum / n + 0.5);

        list.sort(Comparator.naturalOrder());

        int max_value = 0, max_count = 0;
        int last_value = 0, last_count = 0;
        int change = 0;

        for(int i = 0; i < list.size(); i++){
            if(last_count == 0) last_value = list.get(i);

            if(last_value != list.get(i) || i == list.size() - 1){
                if(last_value == list.get(i)) last_count++;

                if(last_count > max_count){
                    max_count = last_count;
                    max_value = last_value;
                    change = 1;
                }
                else if(last_count == max_count && change != 2){
                    max_count = last_count;
                    max_value = last_value;
                    change++;
                }

                last_value = list.get(i);
                last_count = 1;
            }
            else last_count++;
        }

        bw.write( avg + "\n" + list.get(n / 2) + "\n" + max_value + "\n" + (list.get(list.size() - 1) - list.get(0)));
        bw.flush();
        bw.close();
    }
}