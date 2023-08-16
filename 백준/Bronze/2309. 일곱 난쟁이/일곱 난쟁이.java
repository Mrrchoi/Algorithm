import java.util.*;

public class Main {
    public static void Combination(int[] height, int[] target, int lenIdx, int tgtIdx){
        if(tgtIdx == target.length){
            int sum = 0;

            for(int t : target) sum += t;

            if(sum == 100){
                Arrays.sort(target);

                for(int len : target) System.out.println(len);

                System.exit(0);
            }
            else return;
        }
        else if(lenIdx == height.length) return;

        target[tgtIdx] = height[lenIdx];
        Combination(height, target, lenIdx + 1, tgtIdx + 1);
        Combination(height, target, lenIdx + 1, tgtIdx);
    }


    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int[] height = new int[9];
        int[] target = new int[7];

        for(int i = 0; i < 9; i++) height[i] = sc.nextInt();

        Combination(height, target, 0, 0);
    }
}