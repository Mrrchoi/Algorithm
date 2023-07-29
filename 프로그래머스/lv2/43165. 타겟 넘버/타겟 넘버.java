class Solution {
    public static int dfs(int[] numbers, int target, int idx, int sum){
        if(numbers.length == idx){
            if(sum == target) return 1;
            else return 0;
        }

        return dfs(numbers, target, idx + 1, sum + numbers[idx]) + dfs(numbers, target, idx + 1, sum - numbers[idx]);
    }
    public int solution(int[] numbers, int target) {
        int answer = dfs(numbers, target, 0, 0);
        return answer;
    }
}