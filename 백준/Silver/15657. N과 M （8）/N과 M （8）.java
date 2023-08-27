import java.util.*;

public class Main {
    public static void com(int[] source, int[] target, int tgtIdx, int srcIdx){
        if(tgtIdx == target.length){
            for(int value : target) System.out.print(value + " ");
            System.out.println();
            return;
        }

        for(int i = srcIdx; i < source.length; i++){
            target[tgtIdx] = source[i];

            com(source, target, tgtIdx + 1, i);
        }

    }
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] source = new int[n];
        int[] target = new int[m];

        for(int i = 0; i < n; i++) source[i] = sc.nextInt();

        Arrays.sort(source);

        com(source, target, 0, 0);

    }
}