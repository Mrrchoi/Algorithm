import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, String> map = new HashMap<>();
        TreeMap<String, Integer> time = new TreeMap<>();

        for(int i = 0; i < records.length; i++){
            String[] record = records[i].split(" ");

            if(record[2].equals("IN")) map.put(record[1], record[0]);
            else if(record[2].equals("OUT")){
                String[] in_time = map.get(record[1]).split(":");
                String[] out_time = record[0].split(":");
                int total_time = (Integer.parseInt(out_time[0]) - Integer.parseInt(in_time[0])) * 60 + (Integer.parseInt(out_time[1]) - Integer.parseInt(in_time[1]));
                //int total_fee = total_time <= fees[0] ? fees[1] : fees[1] + (int)Math.round((double)((total_time - fees[0]) / fees[2])) * fees[3];

                time.putIfAbsent(record[1], 0);
                time.put(record[1], time.get(record[1]) + total_time);

                map.remove(record[1]);
            }
        }

        if(map.size() != 0){
            for(String car_number : map.keySet()){
                String[] in_time = map.get(car_number).split(":");
                int total_time = (23 - Integer.parseInt(in_time[0])) * 60 + (59 - Integer.parseInt(in_time[1]));

                time.putIfAbsent(car_number, 0);
                time.put(car_number, time.get(car_number) + total_time);

            }
        }

        for(String car_num : time.keySet()) System.out.println(car_num + " " + time.get(car_num));

        int[] answer = new int[time.size()];
        int idx = 0;

        for(String car_number : time.keySet()) answer[idx++] = time.get(car_number) <= fees[0] ? fees[1] : fees[1] + (time.get(car_number) - fees[0] + fees[2] - 1) / fees[2] * fees[3];
        
        
        return answer;
    }
}