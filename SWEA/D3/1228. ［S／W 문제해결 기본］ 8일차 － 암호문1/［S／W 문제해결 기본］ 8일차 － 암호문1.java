import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for(int t = 1; t <= 10; t++){
            LinkedList<Integer> linkedList = new LinkedList<>();
            int n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < n; i++) linkedList.add(Integer.parseInt(st.nextToken()));

            int m = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()){
                st.nextToken();
                int idx = Integer.parseInt(st.nextToken());
                int len = Integer.parseInt(st.nextToken());

                for(int i = 0; i < len; i++) linkedList.add(idx + i, Integer.parseInt(st.nextToken()));
            }

            bw.write("#" + t);
            for(int i = 0; i < 10; i++) bw.write(" " + linkedList.get(i));
            bw.newLine();
        }

        bw.close();

    }
}