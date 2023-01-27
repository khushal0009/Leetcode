class Solution {
    public int numDecodings(String s) {
        if (s.length()==1)
        {if (s.charAt(0)=='0')
                return 0;
         return 1;
        }
        
        
        // Number of ways to separate/ partition digits such that value of any number is less than 26
        int dp[]= new int[s.length()];
        Arrays.fill(dp, -1);
        return countWays(s, 0, dp);
        
        
        
    }
    
    public int countWays(String str, int ind, int[] dp)
    {
        // Base Case
        if (ind>= str.length())
            return 1;
        
        if (dp[ind]!=-1)
            return dp[ind];
        
        int tdw=0, odw=0;
        // One digit ways
        if (str.charAt(ind)-'0'==0)
            return 0;
        odw= countWays(str, ind+1, dp); // New sub-problem
        
        // Two digit ways
        if (ind <str.length()-1 && Integer.parseInt(str.substring(ind, ind+2))<=26 && Integer.parseInt(str.substring(ind, ind+2))>9)
            tdw= countWays(str, ind+2, dp);
        
        return dp[ind]= tdw+odw;
    }
}