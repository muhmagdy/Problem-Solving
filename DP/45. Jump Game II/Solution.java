class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for(int i = n-2; i >= 0; i--){
            int min = 500000;
            for(int j = i+1; j <= i+nums[i] && j < n; j++)
                min = Math.min(min, dp[j]);
            dp[i] = min + 1;
        }
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }
}