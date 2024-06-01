import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        HashSet<String> set = new HashSet<>();
        int resultLeft = 0, resultRight = gems.length;
        
        for (String gem : gems) {
            set.add(gem);
        }
        
        HashMap<String, Integer> map = new HashMap<>();
        int size = set.size();
        int left = 0, right = 0;
    
        map.put(gems[0], 1);
        
        while (left <= right && right < gems.length) {
            if (map.size() == size) {
                if (resultRight - resultLeft > right - left) {
                    resultRight = right;
                    resultLeft = left;
                }
                
                map.put(gems[left], map.get(gems[left]) - 1);
                
                if (map.get(gems[left]) == 0) {
                    map.remove(gems[left]);
                }
                
                left++;
            }
            else {
                right++;
                
                if (right < gems.length) {
                map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
                    
                }
            }
        }
        
        return new int[]{resultLeft + 1, resultRight + 1};
    }
}