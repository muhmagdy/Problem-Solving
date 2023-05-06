class Solution {
    public int numSubseq(int[] nums, int target) {
        int n = 0, mod = 1000000007; 
        int l = 0, r = nums.length-1;
        
        int[] pow = new int[nums.length];
        pow[0] = 1;
        for(int i = 1; i < nums.length; i++)
            pow[i] = pow[i-1]*2 % mod;
        
        Arrays.sort(nums);
        
        while(l <= r){
            if(nums[l] + nums[r] <= target)
                n = (n+pow[r-l++]) % mod;
            else
                r--;
        }
        return n;
    }

}