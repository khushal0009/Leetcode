class Solution {
    public int diagonalSum(int[][] mat) {
        int res=0;
        int idx=mat.length-1;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                if(i==j){
                    res+=mat[i][j];
                }
            }
        }
        for(int i=0;i<mat.length;i++){
            for(int j=mat[i].length-1;j>=0;j--){
                if(i+j==idx && i!=j){
                    res+=mat[i][j];
                }
            }
        }
        return res;
    }
}