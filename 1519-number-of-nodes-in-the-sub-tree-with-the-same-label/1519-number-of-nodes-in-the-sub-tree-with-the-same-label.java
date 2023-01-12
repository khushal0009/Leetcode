class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        int[] ans = new int[n];
        boolean[] visited = new boolean[n];

        helper(adj, 0, labels, ans, visited);
        return ans;
    }

    private int[] helper(List<List<Integer>> adj, int curr, String labels, int[] ans, boolean[] visited){
        if(visited[curr]){
            return new int[26];
        }
        char c = labels.charAt(curr);
        int[] arr = new int[26];
        arr[c - 'a']++;
        visited[curr] = true;
        for(int child : adj.get(curr)){
            int[] childArr = helper(adj, child, labels, ans, visited);
            for(int i = 0; i < 26; i++){
                arr[i] += childArr[i];
            }
        }

        // as mentioned in the intution, we are doing operation at the end of the dfs
        ans[curr] = arr[c - 'a'];
        return arr;
    }
}