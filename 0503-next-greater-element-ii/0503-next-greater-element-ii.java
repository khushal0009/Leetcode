class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[nums.length];
        int n = nums.length;

        for(int i=2*n-1; i>=0; i--)
        {
            while(!st.empty() && nums[i%n] >= st.peek())
            {
                st.pop();
            }
            if(i<n){
                if(st.empty())
                    ans[i%n] = -1;
                else
                    ans[i%n] = st.peek();
            }
            st.push(nums[i%n]);
        }
        return ans;
    }
}