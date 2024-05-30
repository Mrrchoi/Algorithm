class Solution {
    public int maxCount = 0;
    public int maxSales = 0;
    
    public void function(int[][] users, int[] emoticons, int[] salesPercent, int idx) {
        if (idx == emoticons.length) {
            boolean[] isOk = new boolean[users.length];
            int count = 0;
            int sales = 0;
            
            for(int i = 0; i < isOk.length; i++) {
                int total = 0;
                
                for (int j = 0; j < emoticons.length; j++) {
                    if (salesPercent[j] * 10 >= users[i][0]) {
                        total += emoticons[j] * (1 - salesPercent[j] / 10.0);
                    }
                }
                
                if (total >= users[i][1]) {
                    count++;
                }
                else {
                    sales += total;
                }
            }
            
            if (count > maxCount || (count == maxCount && sales > maxSales)) {
                maxCount = count;
                maxSales = sales;
            }
            
            return;
        }
        
        for (int i = 1; i <= 4; i++) {
            salesPercent[idx] = i;
            function(users, emoticons, salesPercent, idx + 1);
        }
    }
    
    public int[] solution(int[][] users, int[] emoticons) {
        function(users, emoticons, new int[emoticons.length], 0);
        return new int[]{maxCount, maxSales};
    }
}