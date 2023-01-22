class Pair{

    int rowNum; 

    int colNum;

    Pair(int i, int j){

        rowNum=i;

        colNum=j;

    }

}

 

class Solution {

    // Function to find the number of islands.

    public void BFS(char[][] grid, boolean [][]visit, int i, int j){

        

        ArrayDeque<Pair> q = new ArrayDeque<>();

        q.add(new Pair(i,j));

        visit[i][j] = true;

        

        while(!q.isEmpty()){

           Pair p = q.poll();

           int row = p.rowNum;

           int col = p.colNum;

           int adjRow = 0;

           int adjCol = 0;

           

           // In these loop we are visiting all the cell which are connected to the present cell these are **top-left, top-up, top-right, mid-left, mid-right, bottom-left, bottom-down, bottom-right** and checking if these cell contains 1 and are not visited then we add them to queue and mark them visited because these cell are reachable through the current cell

 

 

           for(int vicinityRow=-1; vicinityRow<=1; vicinityRow++){

               for(int vicCol=-1; vicCol<=1; vicCol++){

                   adjRow=row+vicinityRow; adjCol=col+vicCol;

                   if((Math.abs(vicinityRow-vicCol)==1)&&(adjRow>=0 && adjRow<grid.length) && (adjCol>=0 && adjCol<grid[i].length) && !visit[adjRow][adjCol] && grid[adjRow][adjCol]=='1'){

                       q.add(new Pair(adjRow,adjCol));

                       visit[adjRow][adjCol]=true;

                   }

                   adjRow=0; adjCol=0;

               }

           }

        }

    }

    

    public int numIslands(char[][] grid) {

        // Code here

        int n = grid.length;

        int m = grid[0].length;

        boolean visit[][] = new boolean[n][m];

        int count=0;

        

        for(int i=0; i<n; i++){

            for(int j=0; j<m; j++){

                if(grid[i][j]=='1' && visit[i][j]==false){

                    BFS(grid,visit,i,j);

                    count++;

                }

            }

        }

        return count;

    }

}
