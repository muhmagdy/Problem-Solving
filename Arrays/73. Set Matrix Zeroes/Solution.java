class Solution {
    public void setZeroes(int[][] matrix) {
        int nRows = matrix.length;
        int nCols = matrix[0].length;
        boolean isFirstRow = false, isFirstCol = false;
        for(int i = 0; i < nCols; i++) {
            if (matrix[0][i] == 0) {
                isFirstRow = true;
                break;
            }
        }
        for(int i = 0; i < nRows; i++) {
            if (matrix[i][0] == 0) {
                isFirstCol = true;
                break;
            }
        }
        for(int i = 1; i < nRows; i++){
            for(int j = 1; j < nCols; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int row = 1; row < nRows; row++){
            if(matrix[row][0] == 0)
                zeroRow(matrix, row, nCols);
        }
        for(int col = 1; col < nCols; col++){
            if(matrix[0][col] == 0)
                zeroCol(matrix, col, nRows);
        }
        if(isFirstCol) zeroCol(matrix, 0, nRows);
        if(isFirstRow) zeroRow(matrix, 0, nCols);
    }

    private void zeroRow(int[][] matrix, int row, int nCols){
        for(int i = 0; i < nCols; i++)
            matrix[row][i] = 0;
    }

    private void zeroCol(int[][] matrix, int col, int nRows){
        for(int i = 0; i < nRows; i++)
            matrix[i][col] = 0;
    }
}