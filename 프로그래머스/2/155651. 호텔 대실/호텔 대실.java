import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int[][] time = new int[book_time.length][2];
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < book_time.length; i++) {
            for(int j = 0; j < 2; j++) {
                time[i][j] = Integer.parseInt(book_time[i][j].substring(0, 2)) * 60 + Integer.parseInt(book_time[i][j].substring(3, 5));
                if(j == 1) time[i][j] += 10;
            }
        }

        Arrays.sort(time, (o1, o2) -> o1[0] - o2[0]);

        loop: for(int[] current : time) {
            for(int i = 0; i < list.size(); i++) {
                if(current[0] >= list.get(i)) {
                    list.set(i, current[1]);
                    continue loop;
                }
            }
            
            list.add(current[1]);
        }
        
        return list.size();
    }
}