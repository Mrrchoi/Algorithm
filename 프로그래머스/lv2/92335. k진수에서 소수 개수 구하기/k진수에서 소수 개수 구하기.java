class Solution {
    public boolean is_Prime(long n){
        if(n == 1) return false;
        
        for(long i = 2; i <= (long)Math.sqrt(n); i++) if(n % i == 0) return false;
        
        return true;
    }
    public int solution(int n, int k) {
        String s = Integer.toString(n, k);
        int answer = 0;
        
        for(int i = 0; i < s.length(); i++){
            int end_idx = i;
            
            for(int j = i; j < s.length(); j++){
                if(s.charAt(j) == '0'){
                    end_idx = j;
                    break;
                }
                
                if(j == s.length() - 1) end_idx = s.length();
            }
            
            if(i == end_idx) continue;
            
            if(is_Prime(Long.parseLong(s.substring(i, end_idx)))) answer++;
            
            i = end_idx;
        }
        
        return answer;
    }
}