class Solution {
    public long solution(int k, int d) {
        double n = Math.pow(d, 2) / Math.pow(k, 2);
        long total = 0;
        
        for (int i = 0; i <= Math.sqrt(n); i++) {
            double dynamicN = n - Math.pow(i, 2);
            
            total += (long) Math.sqrt(dynamicN) + 1;
        }
        
        return total;
    }
}