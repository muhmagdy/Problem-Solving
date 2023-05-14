class Solution {
    public int maxScore(int[] nums) {
        int n = nums.length;
        int[][] gcdValues = new int[n][n];
        int dp[] = new int[Integer.MIN_VALUE >>> (32-n-1)];
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                int res = gcd(nums[i], nums[j]);
                gcdValues[i][j] = res;
                gcdValues[j][i] = res;
            }
        }
        boolean[] visited = new boolean[n];
        return solve(1, nums, visited, dp, gcdValues, 0, n);
    }

    private int solve(int op, int[] nums, boolean[] visited, int[] dp, int[][] gcdValues, int bitmask, int n){
        if(dp[bitmask] > 0) return dp[bitmask];
        int maxScore = 0;
        for(int i = 0; i < n; i++){
            if(visited[i]) continue;
            visited[i] = true;
            bitmask |= 1 << i;
            for(int j = i+1; j < n; j++){
                if(visited[j]) continue;
                visited[j] = true;
                bitmask |= 1 << j;
                int curr = op * gcd(nums[i], nums[j]);
                int next = solve(op+1, nums, visited, dp, gcdValues, bitmask, n);
                maxScore = Math.max(maxScore, curr + next);
                visited[j] = false;
                bitmask &= ~(1 << j);
            }
            visited[i] = false;
            bitmask &= ~(1 << i);
        }
        dp[bitmask] = maxScore;
        return maxScore;
    }

    private int gcd(int a, int b){
        if(b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
}