class Solution {
    public int minDeletionSize(String[] strs) {
        int stringSize = strs[0].length();
        int nCols = 0;
        for(int i = 0; i < stringSize; i++){
            for(int j = 0; j < strs.length-1; j++){
                if(strs[j].charAt(i) > strs[j+1].charAt(i)){
                    nCols++;
                    break;
                }
            }
        }
        return nCols;
    }
}