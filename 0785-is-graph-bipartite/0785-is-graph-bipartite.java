class Solution {

    private int[][] graph;
    private boolean sets[][];

    private boolean setCheck(int n) {
        
        // 0 -> left, 1 -> right
        Queue<Pair<Integer, Integer>> q = new ArrayDeque<>();
        q.offer(new Pair<>(n, 0));
        sets[0][n] = true;

        
        while (!q.isEmpty()) {
            Pair<Integer, Integer> cur = q.poll();
            int idx = cur.getValue();
            
            for (int x : graph[cur.getKey()]) {
                if (sets[idx][x]) {
                    return false;
                }
                
                if (!sets[idx ^ 1][x]) {
                    sets[idx ^ 1][x] = true;
                    q.offer(new Pair<>(x, idx ^ 1));
                }
                
            }
        }
        
        return true;
        
    }
    
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        this.graph = graph;
        sets = new boolean[2][n]; 
        
        
        for (int i = 0; i < n; i++) {
            if (!sets[0][i] && !sets[1][i]) {
                if (!setCheck(i)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}