import java.util.*;

class Solution {
    public boolean isOk = false;
    public String[] result;
    public void dfs(HashMap<String, ArrayList<String>> map, ArrayList<String> list, String now, int size) {
        if (list.size() == size) {
            isOk = true;
            
            for (int i = 0; i < size; i++) {
                result[i] = list.get(i);
            }
            
            return;
        }
        
        ArrayList<String> nextList = map.getOrDefault(now, new ArrayList<>());
        
        for (int i = 0; i < nextList.size(); i++) {
            String next = nextList.get(i);
            
            list.add(next);
            
            nextList.remove(i);
            
            map.put(now, nextList);
            
            dfs(map, list, next, size);
            
            if (isOk) {
                return;
            }
            
            list.remove(list.size() - 1);
            
            nextList.add(i, next);
            
            map.put(now, nextList);
        }
    }
    public String[] solution(String[][] tickets) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        for (String[] ticket : tickets) {
            ArrayList<String> list = map.getOrDefault(ticket[0], new ArrayList<String>());
            list.add(ticket[1]);
            
            map.put(ticket[0], list);
        }
        
        for (String key : map.keySet()) {
            ArrayList<String> list = map.get(key);
            
            list.sort(Comparator.naturalOrder());
            
            map.put(key, list);
        }
        
        result = new String[tickets.length + 1];
        
        dfs(map, new ArrayList<>(Arrays.asList("ICN")), "ICN", tickets.length + 1);
        
        return result;
    }
}