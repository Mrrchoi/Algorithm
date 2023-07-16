import java.io.*;
import java.util.*;

public class Main {
    public static String[][] sorted;

    public static void merge_sort(String[][] str){
        sorted = new String[str.length][3];
        merge_sort(str, 0, str.length - 1);
        sorted = null;
    }
    private static void merge_sort(String[][] str, int left, int right){
        if(left == right) return;

        int mid = (left + right) / 2;

        merge_sort(str, left, mid);
        merge_sort(str, mid + 1, right);
        merge(str, left, mid, right);
    }
    public static void merge(String[][] str, int left, int mid, int right){
        int l = left, r = mid + 1, idx = left;

        while(l <= mid && r <= right){
            if(Integer.valueOf(str[l][1]) > Integer.valueOf(str[r][1]) || (Integer.valueOf(str[l][1]) == Integer.valueOf(str[r][1]) && Integer.valueOf(str[l][2]) >= Integer.valueOf(str[r][2]))){
                sorted[idx][0] = str[l][0];
                sorted[idx][1] = str[l][1];
                sorted[idx][2] = str[l][2];
                idx++;
                l++;
            }
            else{
                sorted[idx][0] = str[r][0];
                sorted[idx][1] = str[r][1];
                sorted[idx][2] = str[r][2];
                idx++;
                r++;
            }

            if(l > mid){
                while(r <= right){
                    sorted[idx][0] = str[r][0];
                    sorted[idx][1] = str[r][1];
                    sorted[idx][2] = str[r][2];
                    idx++;
                    r++;
                }
            }
            else if(r > right){
                while(l <= mid){
                    sorted[idx][0] = str[l][0];
                    sorted[idx][1] = str[l][1];
                    sorted[idx][2] = str[l][2];
                    idx++;
                    l++;
                }
            }
        }

        for(int i = left; i <= right; i++){
            str[i][0] = sorted[i][0];
            str[i][1] = sorted[i][1];
            str[i][2] = sorted[i][2];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, Integer> words = new TreeMap<>();

        // 값 입력 받기, 길이가 m 보다 작으면 무시
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String word = st.nextToken();

            if(word.length() >= m){
                words.putIfAbsent(word, 0);
                words.put(word, words.get(word) + 1);
            }
        }

        //merge sort를 위해 문자열 생성 후 문자열과 빈도수를 value로 전달
        String[][] str = new String[words.size()][3];
        int idx = 0;

        for(String s : words.keySet()){
            str[idx][0] = s;
            str[idx][1] = String.valueOf(words.get(s));
            str[idx][2] = String.valueOf(str[idx][0].length());
            idx++;
        }

        merge_sort(str);

        for(int i = 0; i < str.length; i++) {
            bw.write(str[i][0]);
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}