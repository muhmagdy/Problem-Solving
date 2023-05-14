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
        for(int bitmask = (Integer.MIN_VALUE >>> (32-n-1)) - 1; bitmask >= 0; bitmask--){
            int numbersTaken = Integer.bitCount(bitmask);
            if(numbersTaken % 2 != 0) continue;
            int pairsFormed = numbersTaken/2;
            int maxScore = 0;
            for(int i = 0; i < n; i++){
                if((bitmask & (1 << i)) > 0) continue;
                bitmask |= 1 << i;
                for(int j = 0; j < n; j++){
                    if((bitmask & (1 << j)) > 0) continue;
                    bitmask |= 1 << j;
                    int currScore = (pairsFormed + 1) * gcdValues[i][j];
                    int nextScore = dp[bitmask];
                    maxScore = Math.max(maxScore, currScore + nextScore);
                    bitmask &= ~(1 << j);
                }
                bitmask &= ~(1 << i);
                dp[bitmask] = maxScore;
            }
        }
        return dp[0];
    }

    private int gcd(int a, int b){
        if(b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
}