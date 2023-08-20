import java.util.*;

class Solution {
    public int solution(int[] order) {
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        int answer = 0;

        for(int i = 1; i <= order.length; i++) queue.offer(i);

        while(answer < order.length){
            while(!queue.isEmpty() && queue.peek() <= order[answer]) stack.push(queue.poll());

            if(!stack.isEmpty() && stack.peek() == order[answer]){
                stack.pop();
                answer++;
            }
            else break;
        }
        
        return answer;
    }
}