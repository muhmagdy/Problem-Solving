class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int[] beauties = new int[nums.length-k+1];
        int[] freq = new int[50];
        for(int i = 0; i < nums.length; i++){
            if(i-k >= 0 && nums[i-k] < 0) freq[nums[i-k]+50]--;
            if(nums[i] < 0) freq[nums[i]+50]++;
            if(i < k-1) continue;
            int order = 0;
            for(int j = 0; j < 50; j++){
                order += freq[j];
                if(order >= x){
                    int beauty = j-50;
                    beauties[i-k+1] = beauty;
                    break;
                }
            }
        }
        return beauties;
    }
}