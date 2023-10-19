import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int idx_al = 0, idx_ar = A.length - 1;
        int idx_bl = 0, idx_br = B.length - 1;

        Arrays.sort(A);
        Arrays.sort(B);

        while (idx_br >= idx_bl) {
            if(B[idx_br] > A[idx_ar]) {
                answer++;
                idx_br--;
                idx_ar--;
            }
            else {
                idx_ar--;
                idx_bl++;
            }
        }

        return answer;
    }
}