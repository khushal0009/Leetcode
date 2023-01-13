class Solution {
    public int findDuplicate(int[] nums) {
        
        int slow=nums[0];
        int fast=nums[0];
        do{
            slow=nums[slow];
            fast=nums[nums[fast]];
        }while(slow!=fast);
        
        fast=nums[0];
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
        
        // int duplicate=0;
        // for(int i=0;i<nums.length;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //           if(nums[i]==nums[j]){
        //               duplicate=nums[i];
        //               break;
        //           }
        //     }
        // }
        // return duplicate;
    }
}