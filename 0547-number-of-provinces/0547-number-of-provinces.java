class Solution {
    public int findCircleNum(int[][] isConnected) {
//count is for counting the no of provinces
        int count=0;
        int N=isConnected.length;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

        for(int i=0;i<N;i++){
            adj.add(new ArrayList<>());
        }
// converting matrix to adjacency list
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[0].length;j++){
                if(isConnected[i][j]==1 && i!=j){
                adj.get(i).add(j);
                adj.get(j).add(i);
                }
            }
        }

        int vis[]=new int [N];
        for(int i=0;i<N;i++){
// if it is not visited 
            if(vis[i]==0){
// increment the count
            count++;
            dfs(i,vis,adj);
            }
        }
        return count;
    }
// call the dfs
    public void dfs(int node, int vis[],
        ArrayList<ArrayList<Integer>>  adj){
            vis[node]=1;
            for(int it:adj.get(node)){
                if(vis[it]==0){
                    dfs(it,vis,adj);
                }
            }
        }
   

    
}