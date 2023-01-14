class Solution{
public int minSubArrayLen(int target, int[] nums) {
    
//      HashMap<Integer,Integer> hm = new HashMap<>();
//     int sum=0, ans=Integer.MAX_VALUE;
//     for(int i=0;i<nums.length;i++)
//     {
//         sum+=nums[i];
//         if(sum>=target)
//             ans = i+1;

//         //prefix sum condition
//         if(hm.containsKey(sum-target))
//             ans = Math.min(ans, i-hm.get(sum-target));
//         //putting curr sum and its index of occurence in hashmap
//         hm.put(sum,i);
//     }
//     }
//     if(ans==Integer.MAX_VALUE)
//         return 0;
//     else
//         return ans;
    
// }
    
    
// basic constraint checking
  if (nums == null || nums.length == 0)
    return 0;
  
  // initialization of the start & end index of your sliding window 
  int start = 0,  end = 0,  sum = 0,  minLength = Integer.MAX_VALUE;
  
  while (end < nums.length) {
    // keep a running sum as the end pointer expands your window
    sum += nums[end++];
	
    // this while loop will be skipped until your window meets the condition that 
	// the running sum is equal or greater than the int 's' passed in. aka the window
	// is valid
    while (sum >= target) {
	// now you want to condense your window to find the minimum window as the 
	// problem wants
	
	  // updates the min length
      minLength = Math.min(minLength, end - start);
	  
	  // this moves your start index by one condensing your window and 
	  // decreasing the sum to make sure that it's still valid
      sum -= nums[start++];
    }
  }
  
  // if no min is found, return 0 or else return the min length you found above. 
  return minLength == Integer.MAX_VALUE ? 0 : minLength;
}
}