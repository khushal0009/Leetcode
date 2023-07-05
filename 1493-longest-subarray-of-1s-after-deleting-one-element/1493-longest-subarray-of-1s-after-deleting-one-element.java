class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
        boolean present = false;
        for(int i=0;i<nums.length; i++)
        {
            if(nums[i]==0)
            {
                present = true;
                int left = i-1;
                int right= i+1;
                while(left>=0 && nums[left]==1)
                left--;
                while(right<nums.length && nums[right]==1)
                right++;
                left++;
                right--;
                max =  Math.max(max,right-left);
            }
        }
        if(!present)return nums.length-1;
        return max;
    }
}