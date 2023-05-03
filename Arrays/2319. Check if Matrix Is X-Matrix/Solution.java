class Solution {
    public boolean checkXMatrix(int[][] grid) {
        int nRows = grid.length;
        int nCols = grid[0].length;
        for(int i = 0; i < nRows; i++){
            for(int j = 0; j < nCols; j++){
                if(i == j || i == nCols-j-1){
                    if(grid[i][j] == 0)
                        return false;
                }
                else if(grid[i][j] != 0){
                    return false;
                }
            }
        }
        return true;
    }
}