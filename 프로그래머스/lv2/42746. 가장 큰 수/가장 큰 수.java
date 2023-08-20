import java.util.*;

class Solution {
    public static int[] sorted;

    public static void merge_sort(int[] numbers){
        sorted = new int[numbers.length];
        merge_sort(numbers, 0, numbers.length - 1);
        sorted = null;
    }
    public static void merge_sort(int[] numbers, int left, int right){
        if(left == right) return;

        int mid = (left + right) / 2;
        merge_sort(numbers, left, mid);
        merge_sort(numbers, mid + 1, right);
        merge(numbers, left, mid, right);
    }
    public static void merge(int[] numbers, int left, int mid, int right){
        int idx = left, l = left, r = mid + 1;

        while(l <= mid && r <= right){
            StringBuffer sb1 = new StringBuffer("" + numbers[l] + numbers[r]);
            StringBuffer sb2 = new StringBuffer("" + numbers[r] + numbers[l]);

            if(Integer.parseInt(sb1.toString()) > Integer.parseInt(sb2.toString())) sorted[idx++] = numbers[l++];
            else sorted[idx++] = numbers[r++];

            if(l == mid + 1) while(r <= right) sorted[idx++] = numbers[r++];

            else if(r == right + 1) while(l <= mid) sorted[idx++] = numbers[l++];
        }

        for(int i = left; i <= right; i++) numbers[i] = sorted[i];
    }
    
    public String solution(int[] numbers) {
        StringBuffer sb = new StringBuffer("");

        merge_sort(numbers);

        if(numbers[0] == 0) sb.append("0");
        else for(int num : numbers) sb.append(num);
        
        return sb.toString();
    }
}