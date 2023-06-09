public class Solution {
    public int hammingWeight(int n) {
        int nBits = 0;
        while(n != 0){
            nBits += n&1;
            n >>>= 1;
        }
        return nBits;
    }
}