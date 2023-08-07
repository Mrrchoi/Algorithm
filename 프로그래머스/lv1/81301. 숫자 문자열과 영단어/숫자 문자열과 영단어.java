class Solution {
    public int solution(String s) {
        String[] alpha = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for(int i = 0; i < 10; i++) s = s.replace(alpha[i], i + "");
        
        return Integer.parseInt(s);
    }
}