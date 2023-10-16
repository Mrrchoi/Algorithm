import java.util.*;

class Solution {
    public Map<Character, Integer> map = new HashMap<Character, Integer>(){{
        put('A', 0); put('C', 1); put('F', 2); put('J', 3);
        put('M', 4); put('N', 5); put('R', 6); put('T', 7);
    }};
    public int answer = 0;
    public boolean promising(int[] arr, String[] data){
        for(int i = 0; i < data.length; i++) {
            char op = data[i].charAt(3);
            int value = data[i].charAt(4) - '0';
            int gap = Math.abs(arr[map.get(data[i].charAt(0))] - arr[map.get(data[i].charAt(2))]) - 1;

            if(op == '=' && gap != value) return false;
            else if(op == '>' && gap <= value) return false;
            else if(op == '<' && gap >= value) return false;
        }

        return true;
    }
    public void permutation(int[] arr, String[] data, int depth) {
        if(depth == 8) {
            if(promising(arr, data)) answer++;
            return;
        }

        for(int i = depth; i < 8; i++) {
            swap(arr, i, depth);
            permutation(arr, data, depth + 1);
            swap(arr, i, depth);
        }
    }
    public void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
    public int solution(int n, String[] data) {
        int[] arr = new int[8];

        for(int i = 0; i < 8; i++) arr[i] = i;

        permutation(arr, data, 0);

        return answer;
    }
}