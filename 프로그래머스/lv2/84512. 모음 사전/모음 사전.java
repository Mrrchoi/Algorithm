class Solution {
    public int solution(String word) {
        char[] vowel = {'A', 'E', 'I', 'O', 'U'};
        int answer = 0;
        
        for(int i = 0; i < word.length(); i++){
            int count = 0;
            
            for(int j = 0; j < vowel.length; j++){
                if(word.charAt(i) != vowel[j]) count++;
                else break;
            }
            
            if(count != 0) for(int j = i; j < vowel.length; j++) answer += count * Math.pow(5, j - i);
            
            answer++;
        }
        
        return answer;
    }
}