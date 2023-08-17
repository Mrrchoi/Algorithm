import java.util.*;

public class Solution {
    public static int pow(int n, int m){
        if(m == 0) return 1;
        else return n * pow(n, m - 1);
    }

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 10; i++){
            int t = sc.nextInt();
            int n = sc.nextInt();
            int m = sc.nextInt();

            System.out.println("#" + t + " " + pow(n, m));

        }
    }
}