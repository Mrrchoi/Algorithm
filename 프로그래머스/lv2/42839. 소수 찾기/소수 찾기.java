import java.util.*;

class Solution {
    public static boolean[] visit;
    public static char[] result;

    public static boolean is_prime(int n){
        if(n <= 1) return false;

        for(int i = 2; i <= Math.sqrt(n); i++) if(n % i == 0) return false;

        return true;
    }

    public static void per(char[] number, int idx, Set<Integer> set){
        if(idx == result.length){
            String s = "";
            for(int i = 0; i < result.length; i++) s += result[i];

            if(is_prime(Integer.parseInt(s))) set.add(Integer.parseInt(s));

            return;
        }

        for(int i = 0; i < number.length; i++){
            if(!visit[i]){
                result[idx] = number[i];
                visit[i] = true;
                per(number, idx + 1, set);
                visit[i] = false;
            }
        }
    }
    
    public int solution(String numbers) {
        char[] number = numbers.toCharArray();
        Set<Integer> set = new HashSet<>();

        visit = new boolean[number.length];

        for(int i = 1; i <= number.length; i++) {
            result = new char[i];
            per(number, 0, set);
        }
        
        return set.size();
    }
}