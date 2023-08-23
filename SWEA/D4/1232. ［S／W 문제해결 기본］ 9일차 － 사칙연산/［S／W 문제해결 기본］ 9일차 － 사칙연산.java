import java.util.*;
import java.io.*;

public class Solution {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static double postorder (String[][] tree, int idx) throws Exception {
        if(Character.isDigit(tree[idx][0].charAt(0))) {
            return Double.valueOf(tree[idx][0]);
        }
        else {
            double n1 = postorder(tree, Integer.parseInt(tree[idx][1]));
            double n2 = postorder(tree, Integer.parseInt(tree[idx][2]));

            if(tree[idx][0].charAt(0) == '+') n1 += n2;
            else if(tree[idx][0].charAt(0) == '-') n1 -= n2;
            else if(tree[idx][0].charAt(0) == '*') n1 *= n2;
            else if(tree[idx][0].charAt(0) == '/') n1 /= n2;

            return n1;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int t = 1; t <= 10; t++){
            int n = Integer.parseInt(br.readLine());
            String[][] tree = new String[n + 1][3];

            for(int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                int idx1 = Integer.parseInt(st.nextToken());
                int idx2 = 0;

                tree[idx1][idx2++] = st.nextToken();

                while(st.hasMoreTokens()) tree[idx1][idx2++] = st.nextToken();;
            }

            bw.write("#" + t + " " + (int)postorder(tree, 1) + "\n");
        }

        bw.close();
    }
}