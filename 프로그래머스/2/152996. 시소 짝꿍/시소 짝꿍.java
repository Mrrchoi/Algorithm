import java.util.*;

class Solution {
    public long solution(int[] weights) {
        Map<Double, Integer> map = new HashMap<>();
        long answer = 0;

        Arrays.sort(weights);

        for(int weight : weights) {
            double[] arr = {weight * 1.0, weight * 1.0 / 2.0, weight * 2.0 / 3.0, weight * 3.0 / 4.0};

            for(double n : arr) {
                if(map.containsKey(n)) answer += map.get(n);
            }
            
            map.put((double)weight, map.getOrDefault((double)weight, 0) + 1);
        }
        
        return answer;
    }
}