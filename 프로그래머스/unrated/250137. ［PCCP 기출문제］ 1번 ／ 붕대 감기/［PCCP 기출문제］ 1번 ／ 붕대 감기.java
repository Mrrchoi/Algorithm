class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int current = health;
        int last = 0;
        
        for(int i = 0; i < attacks.length; i++) {
            int time = attacks[i][0] - last - 1;
            
            current += time * bandage[1] + time / bandage[0] * bandage[2];
            
            current = current > health ? health : current;
            
            current -= attacks[i][1];
            
            if(current <= 0) {
                return -1;
            }
            
            last = attacks[i][0];
        }
        
        
        return current;
    }
}