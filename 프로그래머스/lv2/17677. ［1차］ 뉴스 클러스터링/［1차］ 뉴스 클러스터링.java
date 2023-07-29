import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        int answer = 65536;

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        for(int i = 0; i < str1.length() - 1; i++) if(Character.isAlphabetic(str1.charAt(i)) && Character.isAlphabetic(str1.charAt(i + 1))) list1.add(str1.substring(i, i + 2));
        for(int i = 0; i < str2.length() - 1; i++) if(Character.isAlphabetic(str2.charAt(i)) && Character.isAlphabetic(str2.charAt(i + 1))) list2.add(str2.substring(i, i + 2));


        if(list1.size() != 0 && list2.size() != 0){
            int intersection = list1.size();

            for(String s : list2) if(list1.contains(s)) list1.remove(s);

            intersection -= list1.size();

            int union = list1.size() + list2.size();

            answer *= (double)intersection / union;
        }
        else if(list1.size() == 0 && list2.size() == 0);
        else answer = 0;
        
        return answer;
    }
}