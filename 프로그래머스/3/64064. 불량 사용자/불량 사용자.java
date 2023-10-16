import java.util.*;
import java.awt.*;

class Solution {
    public static Set<Point> list = new HashSet<>();
    public static void combination(String[] user_id, String[] banned_id, boolean[] banned_user, int idx) {
        if(idx == banned_id.length) {
            int add = 0, multi = 1;

            for(int i = 0; i < banned_user.length; i++) {
                if(banned_user[i]) {
                    add += i + 1;
                    multi *= (i + 1);
                }
            }

            Point p = new Point(add, multi);

            if(!list.contains(p)) list.add(p);

            return;
        }

        String banned = banned_id[idx];

        loop: for(int i = 0; i < user_id.length; i++) {
            if(banned_user[i] || user_id[i].length() != banned.length()) continue;

            for(int j = 0; j < user_id[i].length(); j++) {
                if(user_id[i].charAt(j) != banned.charAt(j) && banned.charAt(j) != '*') continue loop;
            }

            banned_user[i] = true;

            combination(user_id, banned_id, banned_user, idx + 1);

            banned_user[i] = false;
        }
    }
    public static int solution(String[] user_id, String[] banned_id) {
        combination(user_id, banned_id, new boolean[user_id.length], 0);
        return list.size();
    }
}