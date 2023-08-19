import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        int idx = 0;

        loop: while(k != 0){
            if(idx == number.length()){
                while(k != 0){
                    stack.pop();
                    k--;
                    break loop;
                }
            }
            while(!stack.empty() && stack.peek() < number.charAt(idx)){
                stack.pop();
                if(--k == 0) break;
            }

            stack.push(number.charAt(idx++));
        }

        StringBuffer sb = new StringBuffer(number.substring(idx, number.length()));

        while(!stack.empty()) sb = new StringBuffer(stack.pop() + "").append(sb);
        
        return sb.toString();
        
    }
}