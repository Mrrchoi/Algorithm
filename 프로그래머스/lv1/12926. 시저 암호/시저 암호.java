class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
        }
        
        //AB
        
        //문자열을 쪼개서 char형 배열로 반환시키는 거임
        //ch -> ['A', 'B']
        for(char ch : s.toCharArray()){
            if(ch >= 'A' && ch <= 'Z'){ //대문자
                if((ch + n) > 'Z') ch = (char)(ch + n + 'A' - 'Z' - 1);
                else ch = (char)(ch + n);
            }
            else if(ch >= 'a' && ch <= 'z'){
                if((ch + n) > 'z') ch = (char)(ch + n + 'a' - 'z' - 1);
                else ch = (char)(ch + n);
            }
            
            answer += ch;
        }
        
        return answer;
    }
}

//일반적인 상황(눈에 보여 어떻게 해야 될지) / 예외적인 상황(문제에 제시 / 반례 / 테스트 케이스만 통과 실채점 다틀림)
// a - b - c - ... - x - y - z - a...
// 대문자, 소문자는 N만큼 밀어, 공백은 그대로
// a -> b // a -> z
// 문자를 민다 -> 아스키코드 옆 칸!
// A ~ Z, a ~ z 붙어있다