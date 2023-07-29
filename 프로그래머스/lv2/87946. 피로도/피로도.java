class Solution {
    public static int perm(int[][] dungeons, int k, int depth){
        if(depth == dungeons.length) return depth;

        int max = depth;

        for(int i = depth; i < dungeons.length; i++){
            swap(dungeons, i, depth);

            if(dungeons[depth][0] <= k) max = Math.max(max, perm(dungeons, k - dungeons[depth][1], depth + 1));

            swap(dungeons, depth, i);
        }

        return max;
    }
    
    public static void swap(int[][] dungeons, int idx1, int idx2){
        int temp = dungeons[idx1][0];
        dungeons[idx1][0] = dungeons[idx2][0];
        dungeons[idx2][0] = temp;

        temp = dungeons[idx1][1];
        dungeons[idx1][1] = dungeons[idx2][1];
        dungeons[idx2][1] = temp;
    }
    
    public int solution(int k, int[][] dungeons) {
        int answer = perm(dungeons, k, 0) == 0 ? -1 : perm(dungeons, k, 0);
        return answer;
    }
}