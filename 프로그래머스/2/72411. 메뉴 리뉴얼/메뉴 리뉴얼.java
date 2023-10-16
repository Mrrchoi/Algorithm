import java.util.*;

class Solution {
    public static Map<String, Integer> map;
    public static int max;
    public static void combination(String order, String s, int r, int idx) {
        if(r == s.length()) {
            map.putIfAbsent(s, 0);
            map.put(s, map.get(s) + 1);

            max = Math.max(max, map.get(s));

            return;
        }
        else if(idx == order.length()) return;

        combination(order, s + order.charAt(idx), r,idx + 1);
        combination(order, s, r,idx + 1);
    }
    public static String[] solution(String[] orders, int[] course){
        ArrayList<String> answer = new ArrayList<>();

        for(int i = 0; i < orders.length; i++) {
            PriorityQueue<Character> pq = new PriorityQueue<>();
            StringBuffer sb = new StringBuffer("");

            for(int j = 0; j < orders[i].length(); j++) {
                pq.add(orders[i].charAt(j));
            }

            while (!pq.isEmpty()) {
                sb.append(pq.poll());
            }

            orders[i] = sb.toString();
        }

        for(int i = 0; i < course.length; i++) {
            map = new HashMap<>();
            max = 0;

            for(int j = 0; j < orders.length; j++) {
                if(course[i] > orders.length) continue;

                combination(orders[j], "", course[i], 0);
            }

            if(max < 2) continue;

            for(String s : map.keySet()) {
                if(map.get(s) == max) answer.add(s);
            }
        }

        answer.sort(Comparator.naturalOrder());

        return answer.toArray(new String[0]);
    }
}