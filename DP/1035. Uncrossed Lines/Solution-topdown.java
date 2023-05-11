class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++)
                dp[i][j] = -1;
        }
        return maxUncrossedHelper(0,0,nums1,nums2,dp);
    }

    private int maxUncrossedHelper(int x, int y, int[] nums1, int[] nums2, int[][] dp){
        if(dp[x][y] != -1) return dp[x][y];
        if(nums1[x] == nums2[y])
            dp[x][y] = maxUncrossedHelper(x+1,y+1,nums1,nums2,dp) + 1;
        else dp[x][y] = Math.max(maxUncrossedHelper(x,y+1,nums1,nums2,dp), maxUncrossedHelper(x+1,y,nums1,nums2,dp));
        return dp[x][y];
    }
}