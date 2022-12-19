class Solution {
    public int numSubarrayProductLessThanK(int[] arr, int k) {
        int i=0;
        int j=0;
        int count=0;
        int product=1;
        while(j<arr.length){
            product*=arr[j];
            while(i<=j && product>=k){
                product/=arr[i++];
            }
            count+=(j-i+1);
            j++;
        }
        
        return count;
    }
}