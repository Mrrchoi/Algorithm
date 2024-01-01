import java.util.*;
import java.io.*;

public class Main {
    public static void ToPostOrder(int[] tree, int start, int end) {
        int left = start + 1, right = start + 1;

        while (right <= end && tree[right] < tree[start]) {
            right++;
        }

        if(left < right) ToPostOrder(tree, left, right - 1);
        if (right <= end) ToPostOrder(tree, right, end);

        System.out.println(tree[start]);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        int[] tree = new int[10001];
        int index = 0;

        while ((input = br.readLine()) != null) {
            tree[index++] = Integer.parseInt(input);
        }

        ToPostOrder(tree, 0, index - 1);
    }
}