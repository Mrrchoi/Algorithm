import java.util.*;

public class Main {
    public static void per(int[] source, int[] target, boolean[] visit, int tgtIdx){
        if(tgtIdx == target.length){
            for(int value : target) System.out.print(value + " ");
            System.out.println();
            return;
        }

        for(int i = 0; i < source.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                target[tgtIdx] = source[i];
                per(source, target, visit, tgtIdx + 1);
                visit[i] = false;
            }
        }
    }
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] source = new int[n];
        boolean[] visit = new boolean[n];
        int[] target = new int[m];

        for(int i = 0; i < n; i++) source[i] = i + 1;

        per(source, target, visit, 0);
    }
}