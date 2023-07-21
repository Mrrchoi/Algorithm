import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        TreeMap<Character, Integer> map = new TreeMap<>();

        for(char ch : s.toCharArray()){
            map.putIfAbsent(ch, 0);
            map.put(ch, map.get(ch) + 1);
        }

        char last = '.';
        String front = "";
        String back = "";
        boolean isok = true;

        for(char ch : map.keySet()){
            if(Character.isAlphabetic(last) && map.get(ch) % 2 == 1) {
                isok = false;
                break;
            }
            else if(map.get(ch) % 2 == 1) last = ch;

            for(int i = 0; i < map.get(ch) / 2; i++){
                front += ch;
                back = ch + back;
            }
        }

        if(Character.isAlphabetic(last)) front = front + last + back;
        else front = front + back;

        if(isok) bw.write(front);
        else bw.write("I'm Sorry Hansoo");

        bw.flush();
        bw.close();
    }
}