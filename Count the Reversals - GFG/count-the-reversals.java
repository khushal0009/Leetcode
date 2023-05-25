//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
    		System.out.println (new Sol().countRev (s));
        }
        
    }
}
// Contributed By: Pranay Bansal

// } Driver Code Ends


//User function Template for Java

class Sol
{
    int countRev (String s)
    {
        // your code here       
        if(s.length()%2!=0){
            return -1;
        }
        // Stack<Character> stack=new Stack<Character>();
         int ans=0,open=0,close=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='{'){
                // stack.push(ch);
                open+=1;
            }else{
                // if(stack.isEmpty()|| stack.peek()=='}'){
                    // stack.push(ch);
                    if(open<=0){
            close++;
                }else{
                    // stack.pop();
                    open--;
                }
            }
        }
        // int ans=0,open=0,close=0;
        // while(!stack.isEmpty()){
        //     char top=stack.pop();
        //     if(top=='{'){
        //         open++;
        //     }else{
        //         close++;
        //     }
        // }
        ans=(int)(Math.ceil(open/2.0)+Math.ceil(close/2.0));
        return ans;
    }
}