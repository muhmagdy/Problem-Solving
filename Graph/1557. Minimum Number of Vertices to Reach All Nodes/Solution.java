class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] isReacheable = new boolean[n];
        for(List<Integer> edge: edges){
            isReacheable[edge.get(1)] = true;
        }

        List<Integer> smallestSet = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(!isReacheable[i]) smallestSet.add(i);
        }

        return smallestSet;
    }
}