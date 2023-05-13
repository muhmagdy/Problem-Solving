class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int n = high;
        int[] count = new int[n+1];
        count[n] = 1;
        for(int i = n-1; i >= 0; i--){
            if(i >= low && i <= high) count[i]++;
            if(i+zero <= n) count[i] += count[i+zero];
            if(i+one <= n) count[i] += count[i+one];
            count[i] %= 1000000007;
        }
        return count[0];
    }
}