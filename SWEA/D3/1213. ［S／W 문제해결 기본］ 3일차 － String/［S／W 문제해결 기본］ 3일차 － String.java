import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 10; i++){
            int t = sc.nextInt();
            String search = sc.next();
            String s = sc.next();
            int len = s.length();

            s = s.replace(search, "");

            System.out.println("#" + t + " " + (len - s.length()) / search.length());
        }
    }
}