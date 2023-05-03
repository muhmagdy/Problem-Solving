class Solution {
    public int binaryGap(int n) {
        int gap = 0;
        while(n > 0){
            if((n & 1) == 1){
                int newGap = 1;
                n >>>= 1;
                while((n & 1) == 0 && n > 0){
                    newGap++;
                    n >>>= 1;
                }
                if(newGap > gap && n > 0)
                    gap = newGap;
            }else{
                n >>>= 1;
            }        
        }
        return gap;
    }
}