import java.util.*;

class Solution {
    public class Word {
        String s;
        int count;

        public Word(String s, int count) {
            this.s = s;
            this.count = count;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        Queue<Word> queue = new LinkedList<>();
        boolean[] visit = new boolean[words.length];

        queue.offer(new Word(begin, 0));

        while (!queue.isEmpty()) {
            Word now = queue.poll();

            for(int i = 0; i < words.length; i++) {
                if(!visit[i]) {
                    int different = 0;

                    for(int j = 0; j < now.s.length(); j++) {
                        if(now.s.charAt(j) != words[i].charAt(j)) different++;
                    }

                    if(different != 1) continue;

                    if(target.equals(words[i])) return now.count + 1;

                    queue.offer(new Word(words[i], now.count + 1));
                    visit[i] = true;
                }
            }
        }

        return 0;
    }
}