import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int sum = 64;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(64);

        while(true){
            if(sum > x){
                sum -= list.get(list.size() - 1);

                list.set(list.size() - 1, list.get(list.size() - 1) / 2);

                sum += list.get(list.size() - 1);

                if(sum < x) {
                    list.add(list.get(list.size() - 1));
                    sum += list.get(list.size() - 1);
                }
            }

            int result = 0, count = 0;
            for(int i = 0; i < list.size(); i++){
                if(result + list.get(i) <= x) {
                    result += list.get(i);
                    count++;
                }
            }

            if(result == x){
                bw.write(count + "\n");
                break;
            }
        }

        bw.flush();
        bw.close();
    }
}