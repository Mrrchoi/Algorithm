import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<TreeMap<String, Integer>> list = new ArrayList<>();
        ArrayList<Integer> std = new ArrayList<>();

        for(int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            String nickName = st.nextToken();

            if(list.size() == 0) {
                list.add(new TreeMap<>());
                list.get(0).put(nickName, l);
                std.add(l);
            }
            else {
                boolean isOk = false;

                for(int j = 0; j < list.size(); j++) {
                    if(Math.abs(std.get(j) - l) <= 10 && list.get(j).size() < m) {
                        list.get(j).put(nickName, l);
                        isOk = true;
                        break;
                    }
                }

                if(isOk) continue;

                list.add(new TreeMap<>());
                list.get(list.size() - 1).put(nickName, l);
                std.add(l);
            }
        }

        for(TreeMap<String, Integer> map : list) {
            bw.write((map.size() == m ? "Started!\n" : "Waiting!\n"));

            for(String nick : map.keySet()) {
                bw.write(map.get(nick) + " " + nick + "\n");
            }
        }

        bw.close();
    }
}