import java.util.*;

class Solution {
    public HashMap<String, String> substitutionMap = new HashMap<>(){{
        put("C#", "c"); put("D#", "d"); put("F#", "f"); put("G#", "g"); put("A#", "a"); put("B#", "b");
    }};
    
    public String substitution(String s) {
        for (String key : substitutionMap.keySet()) {
            s = s.replace(key, substitutionMap.get(key));
        }
        
        return s;
    }
    
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int max = 0;
        
        m = substitution(m);
        
        for (String musicinfo : musicinfos) {
            String[] str = musicinfo.split(",");
            String[] start = str[0].split(":");
            String[] end = str[1].split(":");
            int time = (Integer.parseInt(end[0]) - Integer.parseInt(start[0]))* 60 + (Integer.parseInt(end[1]) - Integer.parseInt(start[1]));
            
            str[3] = substitution(str[3]);
            
            StringBuilder sb = new StringBuilder(str[3].repeat(time / str[3].length()));
            
            sb.append(str[3].substring(0, time % str[3].length()));
            
            if (sb.toString().contains(m) && time > max) {
                answer = str[2];
                max = time;
            }
        }
        
        return answer;
    }
}