class Solution {
    public int bitwiseComplement(int n) {
        int lastOne = 0;
        for(int i = 0; i < 32; i++)
            if(((n >>> i) & 1) == 1) lastOne = i;
        return (~n) & (-1 >>> (31-lastOne));
    }
}