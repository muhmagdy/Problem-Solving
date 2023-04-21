class Solution {
    public boolean canJump(int[] nums) {
        int nearestTrue = nums.length-1;
        for(int i = nums.length-2; i>=0; i--){
            if(nearestTrue-i <= nums[i]){
                nearestTrue = i;
            }
        }
        return (nearestTrue == 0);
    }
}