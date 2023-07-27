import java.util.*;

public class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> map = new HashMap<>();
        int answer = 0, sum = 0;

        for(int i = 0; i < want.length; i++){
            map.put(want[i], number[i]);
            sum += number[i];
        }

        loop: for(int i = 0; i < discount.length - sum + 1; i++){
            boolean check = true;
            
            if(!map.containsKey(discount[i])) continue;
            
            Map<String, Integer> copy_map = new HashMap<>();
            
            for(int j = i; j < i + sum; j++){
                if(!map.containsKey(discount[j])) continue loop;
                
                copy_map.putIfAbsent(discount[j], 0);
                copy_map.put(discount[j], copy_map.get(discount[j]) + 1);
            }
            
            for(String s : map.keySet()){
                if(!copy_map.containsKey(s)){
                    check = !check;
                    break;
                }
                
                copy_map.put(s, copy_map.get(s) - map.get(s));
                
                if(copy_map.get(s) == 0) copy_map.remove(s);
            }
            
            if(check && copy_map.size() == 0) answer++;
        }

        return answer;
    }
}
