class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] % 2 == 0) answer[i] = numbers[i] + 1;
            else{
                String s = Long.toString(numbers[i],2);
                s = "0" + s;
                int idx = s.lastIndexOf("01");
                s = s.substring(0, idx) + "10" + s.substring(idx + 2, s.length());
                answer[i] = Long.valueOf(s, 2);
            }
        }
        
        return answer;
    }
}