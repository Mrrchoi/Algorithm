class Solution {
    public int removeDuplicates(int[] nums) {
        int std = 0;

        for(int i = 1; i < nums.length; i++) if(nums[std] != nums[i]) nums[++std] = nums[i];

        return std + 1;
    }
}