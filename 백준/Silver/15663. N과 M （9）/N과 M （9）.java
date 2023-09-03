import java.util.*;

public class Main {
    public static void per(int[] source, int[] target, boolean[] visit, int tgtIdx){
        if(tgtIdx == target.length){
            for(int value : target) System.out.print(value + " ");
            System.out.println();

            return;
        }

        int last_value = 0;

        for(int i = 0; i < source.length; i++) {
            if (!visit[i] && source[i] != last_value) {
                last_value = source[i];
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

        for(int i = 0; i < n; i++) source[i] = sc.nextInt();

        Arrays.sort(source);

        per(source, target, visit, 0);
    }
}