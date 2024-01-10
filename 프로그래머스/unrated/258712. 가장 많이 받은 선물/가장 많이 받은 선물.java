import java.util.*;

// 이번 달에 많이 준 사람이 하나 받음
// 없거나 같으면 '선물 지수' 큰 사람이 하나 받음
// 선물 지수: 전체 GIVE - 전체 TAKE
// 이것까지 같아? 그럼 하지마
// MAX?
class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer>[] giveNtake = new HashMap[friends.length];
        Map<String, Integer> friendsMap = new HashMap<>();
        int[] figure = new int[friends.length];
        int[] result = new int[friends.length];
        int answer = 0;
        
        for(int i = 0; i < friends.length; i++) {
            friendsMap.put(friends[i], i);
            giveNtake[i] = new HashMap<>();
        }
        
        for(String gift : gifts) {
            String[] str = gift.split(" ");
            int idx1 = friendsMap.get(str[0]);
            int idx2 = friendsMap.get(str[1]);
            
            giveNtake[idx1].put(str[1], giveNtake[idx1].getOrDefault(str[1], 0) + 1);
            
            figure[idx1]++;
            figure[idx2]--;
        }
        
        for(int i = 0; i < friends.length - 1; i++) {
            for(int j = i + 1; j < friends.length; j++) {
                int num1 = giveNtake[i].getOrDefault(friends[j], 0);
                int num2 = giveNtake[j].getOrDefault(friends[i], 0);
                
                if(num1 > num2 || (num1 == num2 && figure[i] > figure[j])) {
                    result[i]++;
                }
                else if(num1 < num2 || (num1 == num2 && figure[i] < figure[j])) {
                    result[j]++;
                }
            }
        }
        
        for(int value : result) {
            answer = Math.max(answer, value);
        }
        
        return answer;
    }
}