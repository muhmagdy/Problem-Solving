import java.util.HashMap;
import javafx.util.Pair;

class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = mat.length, m = mat[0].length, a = arr.length;
        int[] rowCounter = new int[n];
        int[] colCounter = new int[m];
        HashMap<Integer, Pair<Integer,Integer>> reversedIndex = new HashMap<>(a);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++)
                reversedIndex.put(mat[i][j], new Pair<>(i,j));
        }
        
        for(int k = 0; k < a; k++){
            Pair<Integer,Integer> index = reversedIndex.get(arr[k]);
            int i = index.getKey(), j = index.getValue();
            rowCounter[i]++;
            colCounter[j]++;
            if(rowCounter[i] == m || colCounter[j] == n) return k;
        }
        return -1;
    }
}