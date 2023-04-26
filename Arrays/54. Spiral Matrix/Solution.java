import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int nRows = matrix.length, nCols = matrix[0].length;
        List<Integer> spiral = new ArrayList<>(nRows*nCols);
        int minRow = 0, maxRow = nRows-1, minCol = 0, maxCol = nCols-1;
        while(minRow <= maxRow && minCol <= maxCol){
            for(int i = minCol; i <= maxCol; i++)
                spiral.add(matrix[minRow][i]);
            for(int i = minRow+1; i <= maxRow; i++)
                spiral.add(matrix[i][maxCol]);
            if(minRow+1 > maxRow)
                break;
            for(int i = maxCol-1; i >= minCol; i--)
                spiral.add(matrix[maxRow][i]);
            if(maxCol-1 < minCol)
                break;
            for(int i = maxRow-1; i >= minRow+1; i--)
                spiral.add(matrix[i][minCol]);
            minRow++;
            maxRow--;
            minCol++;
            maxCol--;
        }
        return spiral;
    }
}