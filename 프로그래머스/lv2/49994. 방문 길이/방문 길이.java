import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<String> set = new HashSet<>();
        int x = 0, y = 0;

        for(char dir : dirs.toCharArray()){
            if((dir == 'U' && y == 5) || (dir == 'D' && y == -5) || (dir == 'R' && x == 5) || (dir == 'L' && x == -5)) continue;

            int xx = x;
            int yy = y;

            if(dir == 'U') y += 1;
            else if(dir == 'D') y -= 1;
            else if(dir == 'R') x += 1;
            else if(dir == 'L') x -= 1;

            set.add("" + xx + yy + x + y);
            set.add("" + x + y + xx + yy);
        }

        return set.size() / 2;
    }
}