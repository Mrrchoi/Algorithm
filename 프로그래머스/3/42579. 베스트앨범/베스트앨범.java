import java.util.*;


class Solution {
    public static int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        HashMap<String, Long> sequence = new HashMap<>();
        HashMap<String, PriorityQueue<int[]>> info = new HashMap<>();

        for(int i = 0; i < genres.length; i++) {
            sequence.put(genres[i], sequence.getOrDefault(genres[i], 0L) + plays[i]);

            PriorityQueue<int[]> pq = info.getOrDefault(genres[i], new PriorityQueue<>((o1, o2) -> o1[1] != o2[1] ? Integer.compare(o2[1], o1[1]) : Integer.compare(o1[0], o2[0])));

            pq.add(new int[]{i, plays[i]});

            info.put(genres[i], pq);
        }

        List<String> keySet = new ArrayList<>(sequence.keySet());
        keySet.sort((o1, o2) -> Long.compare(sequence.get(o2), sequence.get(o1)));

        for(String s : keySet) {
            PriorityQueue<int[]> pq = info.get(s);

            for(int i = 0; i < 2; i++) {
                if(pq.isEmpty()) break;
                answer.add(pq.poll()[0]);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}