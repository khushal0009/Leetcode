class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int startIndex = 0;
        int endIndex = nums.length - 1;
        int number;
        while(startIndex < endIndex){
            if(nums[startIndex] % 2 == 0){
                startIndex++;
            }
            else{
                if(nums[endIndex] % 2 == 0){
                    number = nums[startIndex];
                    nums[startIndex++] = nums[endIndex];
                    nums[endIndex--] = number;
                }
                else{
                    endIndex--;
                }
            }
        }
        return nums;
    }
}