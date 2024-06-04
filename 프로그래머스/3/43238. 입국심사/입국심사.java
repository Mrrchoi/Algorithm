

class Solution {
    public long solution(int n, int[] times) {
        long left = 0, right = Long.MAX_VALUE;
        
        for (int time : times) {
            right = Math.min(right, time);
        }
        
        right *= n;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            long total = 0;
            
            for (int i = 0; i < times.length; i++) {
                total += mid / times[i];
            }
            
            if (total < n) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        
        
        return left;
    }
}