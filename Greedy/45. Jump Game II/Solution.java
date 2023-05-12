class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n <= 1) return 0;
        int jumps = 0;
        for(int i = 0; i < n; i++){
            jumps++;
            int max = 0, idx = i;
            if(i+nums[i] >= n-1) break;
            for(int j = i+1; j <= i+nums[i] && j < n; j++){
                if(j + nums[j] >= max){
                    max = j + nums[j];
                    idx = j;
                }
            }
            i = idx-1;
        }
        return jumps;
    }
}