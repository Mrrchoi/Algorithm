class Solution {
    public static int[] count = new int[2];
    public static void quad_compression(int[][] arr, int r, int c, int size){
        int sum = 0;
        for(int i = r; i < r + size; i++){
            for(int j = c; j < c + size; j++){
                sum += arr[i][j];
            }
        }

        if(sum == 0) count[0]++;
        else if(sum == (int)Math.pow(size, 2)) count[1]++;
        else{
            quad_compression(arr, r, c, size / 2);
            quad_compression(arr, r + size / 2, c, size / 2);
            quad_compression(arr, r, c + size / 2, size / 2);
            quad_compression(arr, r + size / 2, c + size / 2, size / 2);
        }

    }
    public int[] solution(int[][] arr) {
        quad_compression(arr, 0, 0, arr.length);

        return count;
    }
}