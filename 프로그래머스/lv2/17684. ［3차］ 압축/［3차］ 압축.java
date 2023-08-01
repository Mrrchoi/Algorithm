import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int[] answer = new int[0];
        int index = 27;
        
        for(int i = 0; i < 26; i++) map.put((char)('A' + i) + "", i + 1);
        
        for(int i = 0; i < msg.length();){
            int k = 0;
            int length = 0;
            
            for(String s : map.keySet()){
                if(i + s.length() <= msg.length() && s.equals(msg.substring(i, i + s.length()))){
                    if(s.length() < length) continue;
                    
                    length = s.length();
                    k = map.get(s);
                }
            }
            
            list.add(k);
            
            if(i + length + 1 <= msg.length()) map.put(msg.substring(i, i + length + 1), index++);
            
            i += length;
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}