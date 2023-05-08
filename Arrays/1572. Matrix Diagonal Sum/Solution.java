class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0, length =  mat.length;
        for(int i = 0; i < length; i++)
            sum += mat[i][i] + mat[i][length-i-1];
        if(length % 2 == 1) sum -= mat[length/2][length/2];
        return sum;
    }
}