class Solution {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> ans=new ArrayList<>();
        
        
//           Set<Integer> hashSet=new HashSet<Integer>();
//         for(int num:nums){
//             hashSet.add(num);
//         }
        
        
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int num:nums){
            if(!mp.containsKey(num)){
                mp.put(num,1);
            }else{
                mp.put(num,mp.get(num)+1);
            }
        }
        // System.out.print(mp.get(3));
       for (Integer i : mp.keySet())
        {
            if(mp.get(i)>nums.length/3)
                ans.add(i);
        }
        return ans;
    }
}