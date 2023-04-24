import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
class Solution {
    public int findCenter(int[][] edges) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int[] edge: edges){
            for(int node: edge){
                Integer count = freq.get(node);
                if(count == null)
                    freq.put(node, 1);
                else
                    freq.put(node, count+1);
            }
        }
        int n = freq.size();
        for(Entry<Integer, Integer> node: freq.entrySet()){
            if(node.getValue() == n-1)
                return node.getKey();
        }
        return -1;
    }
}