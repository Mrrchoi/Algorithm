import java.util.*;
import  java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer>[] magnet = new LinkedList[n];
        int count = 0;

        for(int i = 0; i < n; i++) magnet[i] = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            char[] ch = br.readLine().toCharArray();

            for(int j = 0; j < 8; j++) magnet[i].add(ch[j] - '0');
        }

        int k = Integer.parseInt(br.readLine());

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int[] direction = new int[n];

            direction[num] = Integer.parseInt(st.nextToken());

            for(int j = num + 1; j < n; j++) {
                if(magnet[j - 1].get(2) != magnet[j].get(6)) direction[j] = direction[j - 1] * -1;
                else break;
            }

            for(int j = num - 1; j >= 0; j--) {
                if(magnet[j + 1].get(6) != magnet[j].get(2)) direction[j] = direction[j + 1] * -1;
                else break;
            }

            for(int j = 0; j < n; j++) {
                if(direction[j] == 1) {
                    magnet[j].add(0, magnet[j].get(7));
                    magnet[j].remove(8);
                }
                else if(direction[j] == -1) {
                    magnet[j].add(magnet[j].get(0));
                    magnet[j].remove(0);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            if(magnet[i].get(0) == 1) count++;
        }

        bw.write(count + "");
        bw.close();
    }
}