import java.util.*;

class Solution {
    public int solution(int[] cards) {
        ArrayList<Integer> group = new ArrayList<>();
        int visit_count = 0;
        boolean[] visit = new boolean[cards.length + 1];
        
        for(int i = 0; i < cards.length ;i++) {
            if(!visit[i + 1]) {
                int next = i + 1;
                int group_count = 0;
                
                while (!visit[next]) {
                    visit[next] = true;
                    next = cards[next - 1];
                    visit_count++;
                    group_count++;
                }
                
                group.add(group_count);
            }
            
            if(visit_count == cards.length) break;
        }
        
        group.sort(Comparator.reverseOrder());
        
        if(group.size() == 1) return 0;
        else return group.get(0) * group.get(1);
    }
}