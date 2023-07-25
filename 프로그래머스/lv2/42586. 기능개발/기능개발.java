import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> pro = new LinkedList<>();
        Queue<Integer> speed = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < progresses.length; i++){
            pro.add(progresses[i]);
            speed.add(speeds[i]);
        }

        int total_time = 0;
        int count = 0;

        while(!pro.isEmpty()){
            if(pro.peek() + total_time * speed.peek() >= 100){
                count++;
                pro.poll();
                speed.poll();

                if(pro.isEmpty()) list.add(count);
            }
            else{
                if(count != 0) list.add(count);

                count = 0;

                total_time += (100 - pro.peek() - total_time * speed.peek()) % speed.peek() != 0 ? (100 - pro.peek() - total_time * speed.peek()) / speed.peek() + 1 : (100 - pro.peek() - total_time * speed.peek()) / speed.peek();
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}