import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> user = new HashMap<>();
        Queue<String> log = new LinkedList<>();
        for(String s : record){
            String[] str = s.split(" ");

            if(str[0].equals("Enter") || str[0].equals("Change")) user.put(str[1], str[2]);

            if(!str[0].equals("Change")) log.offer(str[0] + " " + str[1]);
        }

        String[] answer = new String[log.size()];
        int idx = 0;

        while(log.size() != 0){
            String[] str = log.poll().split(" ");

            if(str[0].equals("Enter")) answer[idx++] = user.get(str[1]) + "님이 들어왔습니다.";
            else answer[idx++] = user.get(str[1]) + "님이 나갔습니다.";
        }
        
        return answer;
    }
}