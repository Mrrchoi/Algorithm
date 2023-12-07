import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Map<String, Integer> map = new HashMap<>(){{
           put("code", 0); put("date", 1); put("maximum", 2); put("remain", 3); 
        }};
        ArrayList<int[]> list = new ArrayList<>();
        
        for(int i = 0; i < data.length; i++) {
            if(data[i][map.get(ext)] < val_ext) {
                list.add(data[i]);
            }
        }
        
        list.sort((o1, o2) -> o1[map.get(sort_by)] - o2[map.get(sort_by)]);
        int[][] answer = new int[list.size()][4];
        
        
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}