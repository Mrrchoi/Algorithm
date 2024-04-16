import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, ArrayList> groupMap = new HashMap<>();
        HashMap<String, String> memberMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String group = br.readLine();
            int k = Integer.parseInt(br.readLine());
            ArrayList<String> memberList = new ArrayList<>();

            for (int j = 0; j < k; j++) {
                String member = br.readLine();

                memberList.add(member);

                memberMap.put(member, group);
            }

            memberList.sort(Comparator.naturalOrder());

            groupMap.put(group, memberList);
        }

        for (int i = 0; i < m; i++) {
            String quiz = br.readLine();
            int type = Integer.parseInt(br.readLine());

            switch (type) {
                case 0:
                    ArrayList<String> result = groupMap.get(quiz);

                    for (String member : result) {
                        bw.write(member + "\n");
                    }

                    break;
                case 1:
                    bw.write(memberMap.get(quiz) + "\n");
            }
        }

        bw.close();
    }
}