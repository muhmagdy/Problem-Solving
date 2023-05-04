class Solution {
    public int minFlips(int a, int b, int c) {
        int n = 0;
        while(a > 0 || b > 0 || c > 0){
            if((c & 0x1) == 1){
                if((a & 0x1) == 0 && (b & 0x1) == 0) n++;
            }
            else {
                if((a & 0x1) == 1 && (b & 0x1) == 1) n += 2;
                else if((a & 0x1) == 1 || (b & 0x1) == 1) n++;
            }
            a >>>= 1;
            b >>>= 1;
            c >>>= 1;
        }
        return n;
    }
}