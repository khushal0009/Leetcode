class Solution {
    public int[] shuffle(int[] nums, int n) {
        int x=2*n;
        int narr[]=new int[x];
        int k=1;
        int j=n;
        narr[0]=nums[0];
        for(int i=1;i<x;i++){
            if(i%2!=0){
                    narr[i]=nums[j];
                j++;
            }else{
                narr[i]=nums[k];
                k++;
            }
        }
        
        return narr;
    }
}