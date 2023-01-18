class Solution {
    private int maxSubArray(int[] nums) {
        int sum=0;
        int max=nums[0];
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum>max) max=sum;
            if(sum<0)sum=0;
        }
        return max;
    }
    
    public int maxSubarraySumCircular(int[] nums) {
        if(nums.length==0) return 0;
        int x=maxSubArray(nums);
        int y=0;
        for(int i=0;i<nums.length;i++){
            y+=nums[i];
            nums[i]*=-1;
            
        }
        int z=maxSubArray(nums);
        if(y+z==0){
            return x;
        }else{
            return Math.max(x,y+z);
        }
    }
}