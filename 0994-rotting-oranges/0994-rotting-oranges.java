class Pair{
    int row;
    int col;
    int tm;
    public Pair(int row,int col,int tm)
    {
        this.row = row;
        this.col = col;
        this.tm = tm;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        //making vis matrix which store the vsitde value or rottenorange
        int[][] vis = new int[n][m];
        //making queue to store {row,col,time}
        Queue<Pair> q = new LinkedList<Pair>();
        int cntfresh = 0;
        for(int i = 0; i< n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                //check if grid[i][j] containg rotten orange means value = 2
                if(grid[i][j] == 2)
                {
                    q.add(new Pair(i,j,0));
                    //mark visited in vis[][] array with 2
                    vis[i][j] = 2;
                }
                // grid not having rotten orange means value equal 2 then mark it 0
                else{
                    vis[i][j] = 0;
                }
                //increment cntfresh if grid having 1 value
                if(grid[i][j] == 1) cntfresh++;
            }
        }

        int tm = 0;
        int delrow[] = {-1,0,1,0};
        int delcol[] = {0,1,0,-1};
        int cnt = 0;
        while(!q.isEmpty())
        {
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().tm;
            tm = Math.max(t,tm);
            q.remove();

            for(int i = 0; i < 4; i++)
            {
                int nrow = r + delrow[i];
                int ncol = c + delcol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1)
                {
                    q.add(new Pair(nrow,ncol,t + 1));
                    vis[nrow][ncol] = 2;
                    cnt++;
                }
            }
        }
        if(cnt != cntfresh) return -1;
        return tm;
        
    }
}