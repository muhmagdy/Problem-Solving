import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> numbers = new ArrayList<>();

        int nRows = matrix.length;
        int nCols = matrix[0].length;
        int[] maxInCol = new int[nCols];
        for(int i = 0; i < nCols; i++){
            int max = Integer.MIN_VALUE;
            for(int j = 0; j < nRows; j++){
                if(matrix[j][i] > max)
                    max = matrix[j][i];
            }
            maxInCol[i] = max;
        }

        for(int i = 0; i < nRows; i++){
            int min = Integer.MAX_VALUE;
            List<Integer> columns = new ArrayList<>();
            for(int j = 0; j < nCols; j++){
                if(matrix[i][j] < min){
                    min = matrix[i][j];
                    columns = new ArrayList<>();
                    columns.add(j);
                }
                else if(matrix[i][j] == min){
                    columns.add(j);
                }
            }

            for(int col: columns){
                if(maxInCol[col] == min)
                    numbers.add(min);
            }
        }

        return numbers;
        
    }
}