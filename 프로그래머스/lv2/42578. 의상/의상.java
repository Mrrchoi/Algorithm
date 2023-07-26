import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        int answer = 1;

        for(String[] s : clothes){
            map.putIfAbsent(s[1], 0);
            map.put(s[1], map.get(s[1]) + 1);
        }
        
        for(String s : map.keySet()) answer *= (map.get(s) + 1);
        
        answer -= 1;
        
        return answer;
    }
}