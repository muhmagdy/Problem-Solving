class Solution {
    public int[] countBits(int n) {
        int[] bits = new int[n+1];
        for(int i = 1; i <= n; i++){
            if(i % 2 == 0)
                bits[i] = bits[i/2];
            else
                bits[i] = bits[i-1] + 1;
        }
        return bits;
    }
}