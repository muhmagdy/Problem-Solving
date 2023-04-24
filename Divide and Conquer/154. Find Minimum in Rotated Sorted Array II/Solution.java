class Solution {
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length-1);
    }
    
    public static int findMin(int[] nums, int start, int end){
        if(end-start >= 3)
            return Math.min(findMin(nums, start, (start+end)/2), findMin(nums, (start+end)/2+1, end));
        int min = nums[start];
        for(int i = start+1; i <= end; i++){
            if(nums[i] < min)
                min = nums[i];
        }
        return min;
    }
}