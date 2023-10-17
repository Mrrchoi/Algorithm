class Solution {
    public void permutation(int[] answer, int n, long k) {
        int[] arr = new int[n];
        boolean[] check = new boolean[n];
        int idx = 0;
        
        for(int i = 0; i < arr.length; i++) arr[i] = i + 1;
        
        for(int i = 1;i <= n; i++) {
            for(int j = 0; j < n; j++) {
                if(check[j]) continue;
                
                long fac = factorial(n - i);
                
                if(fac < k) k -= fac;
                else {
                    check[j] = true;
                    answer[idx++] = arr[j];
                    break;
                }
            }
        }
    }
    public long factorial(int n) {
        if(n <= 1) return 1;
        else return n * factorial(n - 1);
    }
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        
        permutation(answer, n, k);
        
        return answer;
    }
}