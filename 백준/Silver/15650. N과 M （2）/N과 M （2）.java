import java.util.*;

public class Main {
    public static void com(int[] source, int[] target, int tgtIdx, int srcIdx){
        if(tgtIdx == target.length){
            for(int value : target) System.out.print(value + " ");
            System.out.println();
            return;
        }
        else if(srcIdx == source.length) return;

        target[tgtIdx] = source[srcIdx];

        com(source, target, tgtIdx + 1, srcIdx + 1);
        com(source, target, tgtIdx, srcIdx + 1);

    }
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] source = new int[n];
        int[] target = new int[m];

        for(int i = 0; i < n; i++) source[i] = i + 1;

        com(source, target, 0, 0);
    }
}