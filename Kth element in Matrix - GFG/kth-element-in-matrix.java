//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
class KthSmallestElement{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=Integer.parseInt(sc.next());
		while(t>0)
		{
			int n=Integer.parseInt(sc.next());
			int[][] a=new int[n][n];
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
    				a[i][j]=Integer.parseInt(sc.next());
    		
			int k=Integer.parseInt(sc.next());
		    Solution ob = new Solution();
		    System.out.println(ob.kthSmallest(a,n,k));
		    
		    t--;
		}
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
	public static int kthSmallest(int[][]mat,int n,int k)
	{
        int r=mat.length;
        int c=mat[0].length;
        int startVal=mat[0][0];
        int endVal=mat[r-1][c-1];
        int midVal;
        while(startVal<=endVal){
            midVal=(startVal+endVal)/2;
            int ans=0;
            for(int i=0;i<r;i++){
                int lo=0,hi=c-1,m;
                while(lo<=hi){
                    m=lo+(hi-lo)/2;
                    if(mat[i][m]<=midVal)lo=m+1;
                    else hi=m-1;
                }
                ans+=lo;
            }
            if(ans<k)startVal=midVal+1;
            else endVal=midVal-1;
            
        }
        return startVal;
    }
}