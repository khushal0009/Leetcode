//{ Driver Code Starts
import java.util.*;
class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			//System.out.println(str.length());
			Solution ob  = new Solution();
			System.out.println(ob.countPS(str));
		t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete below method */

class Solution
{
    long dp[][];
    long countPS(String str)
    {
        // Your code here
        dp=new long[str.length()][str.length()];
        for(long arr[]:dp){
            Arrays.fill(arr,-1);
        }
        
       return  helper(str,0,str.length()-1);
       
     
    }
   
    long mod=1000*1000*1000+7;
    public long helper(String st,int i,int j){
        if(i>j)return 0;
        if(i==j)return dp[i][j]=1;
        if(dp[i][j]!=-1)return dp[i][j]%mod;
        if(st.charAt(i)==st.charAt(j)){
           dp[i][j]=(1%mod+helper(st,i+1,j)%mod+helper(st,i,j-1)%mod)%mod;
        }
        else{
            dp[i][j]=(helper(st,i+1,j)%mod+helper(st,i,j-1)%mod-helper(st,i+1,j-1)%mod+mod)%mod;
        }
           return dp[i][j]%mod;
    }
}