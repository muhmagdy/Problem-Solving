class Solution {
    public int climbStairs(int n) {
        if(n < 2) return n;
        int old = 1, prev = 1, curr = old + prev;
        for(int i = 2; i < n; i++){
            curr = old + prev;
            old = prev;
            prev = curr;
        }
        return old + prev;
    }
}