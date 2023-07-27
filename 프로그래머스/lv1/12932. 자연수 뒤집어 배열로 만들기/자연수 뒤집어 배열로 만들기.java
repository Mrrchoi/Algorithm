class Solution {
    public int[] solution(long n) {
        char[] ch = new StringBuilder(Long.toString(n)).reverse().toString().toCharArray();
        
        int[] answer = new int[ch.length];
        
        for(int i = 0; i < answer.length; i++) answer[i] = ch[i] - '0';
        
        return answer;
    }
}