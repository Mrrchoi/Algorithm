import java.util.*;
import java.io.*;

public class Solution {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void inorder (char[] tree, int idx) throws Exception {
        if(idx < tree.length){
            inorder(tree, idx * 2);
            bw.write(tree[idx]);
            inorder(tree, idx * 2 + 1);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int t = 1; t <= 10; t++){
            int n = Integer.parseInt(br.readLine());
            char[] tree = new char[n + 1];

            for(int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());

                tree[Integer.parseInt(st.nextToken())] = st.nextToken().charAt(0);
            }

            bw.write("#" + t + " ");
            inorder(tree, 1);
            bw.newLine();
        }

        bw.close();
    }
}