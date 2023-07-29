import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer;
        String[] str = s.substring(2, s.length() - 2).replaceAll("\\},\\{", " ").split(" ");
        Set<Integer> set = new LinkedHashSet<>();

        for(int i = 0; i < str.length; i++){
            int min = Integer.MAX_VALUE;
            int idx = 0;

            for(int j = 0; j < str.length; j++){
                if(str[j].length() != 0 && str[j].length() < min){
                    min = str[j].length();
                    idx = j;
                }
            }

            for(String ss : str[idx].split(",")) set.add(Integer.parseInt(ss));

            str[idx] = "";
        }
        
        answer = new int[set.size()];
        
        int i = 0;
        for(int k : set) answer[i++] = k;
        
        return answer;
    }
}