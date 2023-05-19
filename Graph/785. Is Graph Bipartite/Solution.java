class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        UnionFind unionFind = new UnionFind(n);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < graph[i].length; j++){
                if(unionFind.find(i) == unionFind.find(graph[i][j]))
                    return false;
                unionFind.union(graph[i][0], graph[i][j]);
            }
        }

        return true;
    }
}

class UnionFind {
    int[] ids;
    UnionFind(int n){
        ids = new int[n];
        for(int i = 0; i < n; i++) ids[i] = i;
    }

    void union(int x, int y){
        ids[find(x)] = find(y);
    }

    int find(int x){
        if(ids[x] != x) ids[x] = find(ids[x]);
        return ids[x];
    }
}