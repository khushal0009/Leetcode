class Solution {
   public double findMedianSortedArrays(int[] arr1, int[] arr2) {               
        int n = arr1.length;
        int m = arr2.length;
        
        if(m < n){
            return findMedianSortedArrays(arr2, arr1);
        }
                
        int low =0;
        int high = n;
        
        while(low <= high){
            int cut1 = (low +high) / 2;
            int cut2 = (n+m+1)/2 - cut1;
            
            int left1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1-1];
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2-1];
            
            int right1 = cut1 == n ? Integer.MAX_VALUE : arr1[cut1];
            int right2 = cut2 == m ? Integer.MAX_VALUE : arr2[cut2];
            
            if(left1 <= right2 && left2 <= right1){
                if((n + m) %2 == 0){
                    return (Math.max(left1, left2) + Math.min(right1, right2))/2.0;
                }else{
                    return Math.max(left1, left2);
                }
            }else if(left1 > right2){
                high = cut1 - 1;
            }else{
                low = cut1 + 1;
            }
        }
        return 0.0;
    }
}