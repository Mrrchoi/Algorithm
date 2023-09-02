import java.io.*;
import java.util.*;

public class Main {
    public static void preorder(Map<Character, char[]> tree, char node){
        if(node != '.'){
            System.out.print(node);
            preorder(tree, tree.get(node)[0]);
            preorder(tree, tree.get(node)[1]);
        }
    }
    public static void inorder(Map<Character, char[]> tree, char node){
        if(node != '.'){
            inorder(tree, tree.get(node)[0]);
            System.out.print(node);
            inorder(tree, tree.get(node)[1]);
        }
    }
    public static void postorder(Map<Character, char[]> tree, char node){
        if(node != '.'){
            postorder(tree, tree.get(node)[0]);
            postorder(tree, tree.get(node)[1]);
            System.out.print(node);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Map<Character, char[]> tree = new HashMap<>();

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            tree.put(st.nextToken().charAt(0), new char[]{st.nextToken().charAt(0), st.nextToken().charAt(0)});
        }

        preorder(tree, 'A');
        System.out.println();
        inorder(tree, 'A');
        System.out.println();
        postorder(tree, 'A');

        bw.close();
    }
}