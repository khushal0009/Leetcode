//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int majorityElement(int a[], int size)
    {
        if(size==1){
            int ans=a[0];
            return ans;
        }
        int ans=0;
        int cnt=1;
        int no=size/2;
          Arrays.sort(a);
        for(int i=0;i<size-1;i++){
          if(a[i]==a[i+1]){
              cnt++;
              if(cnt>no){
            ans=a[i];
            return ans;
        }
          }else{
              cnt=1;
          }
        }
        return -1;
    }
}