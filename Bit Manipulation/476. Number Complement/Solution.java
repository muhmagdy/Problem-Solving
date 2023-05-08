class Solution {
    public int findComplement(int num) {
        int lastOne = 0;
        for(int i = 0; i < 32; i++)
            if(((num >>> i) & 1) == 1) lastOne = i;
        return (~num) & (-1 >>> (31-lastOne));
    }
}