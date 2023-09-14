class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {

        //directed graph mapping "from" airport to all its "to" airport according to tickets
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for(List<String>t :tickets){
            String from = t.get(0), to = t.get(1);
            if(!graph.containsKey(from)){
                graph.put(from, new PriorityQueue<>(new LexiSmallerComparator()));
            }
            graph.get(from).add(to);
        }

        List<String> ans = new ArrayList<>();
        dfs(graph, "JFK", ans);//depart from JFK
        
        //reverse to get correct order
        Collections.reverse(ans);

        return ans;
    }


    // Custom comparator for lexicographically smaller strings
    static class LexiSmallerComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return s1.compareTo(s2); // Use the natural ordering of strings
        }
    }

    // Helper method for DFS traversal
    private void dfs(Map<String, PriorityQueue<String>> graph, String curr, List<String> ans) {
        while (graph.containsKey(curr) && !graph.get(curr).isEmpty()) {
            String next = graph.get(curr).poll();
            dfs(graph, next, ans);
        }
        ans.add(curr);
    }

}