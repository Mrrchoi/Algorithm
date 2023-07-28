import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        Map<String,Integer> map = new HashMap<>();
        int answer = 0;
        
        for(int i = 0; i < cities.length; i++){
            if(cacheSize == 0 || map.size() == 0){
                map.put(cities[i].toLowerCase(), i);
                answer += 5;
            }
            else if(map.containsKey(cities[i].toLowerCase())){
                map.put(cities[i].toLowerCase(), i);
                answer++;
            }
            else{
                if(map.size() == cacheSize){
                    String key = "";
                    int min = Integer.MAX_VALUE;
                    
                    for(String s : map.keySet()){
                        if(map.get(s) < min){
                            min = map.get(s);
                            key = s;
                        }
                    }
                    
                    map.remove(key);
                }
                
                map.put(cities[i].toLowerCase(), i);
                
                answer += 5;
            }
        }
        
        return answer;
    }
}