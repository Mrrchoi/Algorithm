import java.util.*;

class Solution {
    public int solution(int[] topping) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        int answer = 0;

        for(int tp : topping){
            map1.putIfAbsent(tp, 0);
            map1.put(tp, map1.get(tp) + 1);
        }

        for(int tp : topping){
            map2.putIfAbsent(tp, 0);
            map2.put(tp, map2.get(tp) + 1);

            map1.put(tp, map1.get(tp) - 1);
            if(map1.get(tp) == 0) map1.remove(tp);

            if(map1.size() == map2.size()) answer++;
            else if(map2.size() > map1.size()) break;
        }
        
        return answer;
    }
}