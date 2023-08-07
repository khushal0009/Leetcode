class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int sr=0;
        int er=matrix.length;
        int sc=0;
        int ec=matrix[0].length;
        boolean ans= false;
        
        while(sr<er && sc< ec){
            if(target<=matrix[sr][ec-1]){
                for(int j=0;j<ec;j++){
                    if(target==matrix[sr][j]){
                        return true;
                    }
                }
            }
            sr++;
        }
        // return ans;
        return false;
    }
}