class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        
        for(int i = 0; i < 9; i++){
            boolean[] containsRow = new boolean[9];
            boolean[] containsCol = new boolean[9];
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    int index = board[i][j] - 49;
                    if(containsCol[index])
                        return false;
                    containsCol[index] = true;
                }
                
                if(board[j][i] != '.'){
                    int index = board[j][i] - 49;
                    if(containsRow[index])
                        return false;
                    containsRow[index] = true;
                }
            }
        }
        
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                boolean[] contains = new boolean[9];
                for(int k = 0; k < 3; k++){
                    for(int l = 0; l < 3; l++){
                        if(board[i*3+k][j*3+l] != '.'){
                            int index = board[i*3+k][j*3+l] - 49;
                            if(contains[index])
                                return false;
                            contains[index] = true;
                        }
                    }
                }
                
            }
        }
        return true;
    }
}