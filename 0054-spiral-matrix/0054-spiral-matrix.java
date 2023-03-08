class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> mat=new ArrayList<Integer>();
        int sR=0;
        int eR=matrix.length-1;
        int sC=0;
        int eC=matrix[0].length-1;
        while(sR<=eR && sC<=eC){
            for(int i=sC;i<=eC;i++){
                mat.add(matrix[sR][i]);
            }
            sR++;
            for(int i=sR;i<=eR;i++){
                mat.add(matrix[i][eC]);
            }
            eC--;
            if(sR<=eR){
                for(int i=eC;i>=sC;i--){
                    mat.add(matrix[eR][i]);
                }
            }
            eR--;
            if(sC<=eC){
                for(int i=eR;i>=sR;i--){
                    mat.add(matrix[i][sC]);
                }
            }
            sC++;
        }
        return mat;
    }
}