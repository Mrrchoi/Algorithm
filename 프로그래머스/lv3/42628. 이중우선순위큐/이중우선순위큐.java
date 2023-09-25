import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>();
        int[] answer = new int[2];

        for(String s : operations) {
            char command = s.split(" ")[0].charAt(0);
            int value = Integer.parseInt(s.split(" ")[1]);

            if(command == 'I') {
                set.add(value);
                map.putIfAbsent(value, 0);
                map.put(value, map.get(value) + 1);
            }
            else if(value == 1 && set.size() > 0) {
                int k = set.last();

                map.put(k, map.get(k) - 1);

                if(map.get(k) == 0) {
                    set.remove(k);
                    map.remove(k);
                }
            }
            else if(value == -1 && set.size() > 0) {
                int k = set.first();

                map.put(k, map.get(k) - 1);

                if(map.get(k) == 0) {
                    set.remove(k);
                    map.remove(k);
                }
            }
        }

        if(set.size() != 0) {
            answer[0] = set.last();
            answer[1] = set.first();
        }

        return answer;
    }
}