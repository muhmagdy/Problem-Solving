class Solution {
    public boolean checkValid(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++){
            boolean[] contain = new boolean[matrix.length+1];
            for(int j = 0; j < matrix.length; j++){
                if(contain[matrix[i][j]]) return false;
                contain[matrix[i][j]] = true;
            }
        }
        for(int i = 0; i < matrix.length; i++){
            boolean[] contain = new boolean[matrix.length+1];
            for(int j = 0; j < matrix.length; j++){
                if(contain[matrix[j][i]]) return false;
                contain[matrix[j][i]] = true;
            }
        }
        return true;
    }
}