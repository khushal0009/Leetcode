class Solution {
     static class pair{
        int a,b,t;
        public pair(int a,int b,int t){
            this.a=a;
            this.b=b;
            this.t=t;

        }
    }
   static public int[][] updateMatrix(int[][] mat) {
    int n=mat.length;
    int m=mat[0].length;
    int visit[][]=new int[n][m]; 
    LinkedList<pair>list =new LinkedList<>();   
    for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < m; j++) {
                if(mat[i][j]==0){
                    list.add(new pair(i,j,0));
                    visit[i][j]=1;
                }
            }
        }
        int drow[]={-1,0,1,0};
        int dcol[]={1,1,0,-1};

        while(list.size()>0){
            int s=list.size();
            for (int i = 0; i <s; i++) {
                int x=list.peek().a;
                int y=list.peek().b;
                int t=list.peek().t;
                mat[x][y]=t;
                list.poll();
                
                if(x-1>=0&&visit[x-1][y]==0){
                    visit[x-1][y]=1;
                    list.add(new pair(x-1, y,t+1));
                }
                if(x+1<mat.length&&visit[x+1][y]==0){
                    visit[x+1][y]=1;
                    list.add(new pair(x+1, y,t+1));
                }
                if(y-1>=0&&visit[x][y-1]==0){
                    visit[x][y-1]=1;
                    list.add(new pair(x, y-1,t+1));
                }
                if(y+1<mat[0].length&&visit[x][y+1]==0){
                    visit[x][y+1]=1;
                    list.add(new pair(x, y+1,t+1));
                }


            }
        }
        return mat;
    }
}