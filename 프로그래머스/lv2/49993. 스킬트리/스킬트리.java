class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        loop: for(String s : skill_trees){
            int last_idx = 0;
            
            for(char ch : skill.toCharArray()){
                int idx = s.indexOf(ch);
                
                if((idx != -1 && idx < last_idx) || (last_idx == -1 && idx != -1)) continue loop;
                
                last_idx = idx;
            }
            
            answer++;
        }
        
        return answer;
    }
}