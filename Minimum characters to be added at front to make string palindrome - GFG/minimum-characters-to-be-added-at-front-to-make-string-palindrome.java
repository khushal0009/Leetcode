//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class Solution {

    public static void findLps(String res, int lps[])

    {

        int i = 1;

        int j = 0;

        lps[0] = 0;

        while(i<res.length())

        {

            if(res.charAt(i) == res.charAt(j))

            {

                lps[i] = j+1;

                i++;

                j++;

            }

            else

            {

                if(j == 0)

                {

                    lps[i] = 0;

                    i++;

                }

                else

                {

                    j = lps[j-1];

                }

            }

        }

    }

    public static int minChar(String str) {

       //Write your code here

       StringBuilder s = new StringBuilder();

       s.append(str);

       String rev = s.reverse().toString();

       String res = str.concat("&").concat(rev);

       

       int lps[] = new int[res.length()];

       findLps(res, lps);

       return str.length()-lps[lps.length-1];

    }

}

//{ Driver Code Starts.

class GFG {
	public static void main(String[] args) throws IOException
	{
	    var sc = new FastReader();
	    int test = sc.nextInt();
	    while(test-->0){
    		String s = sc.nextString();
    		System.out.println(Solution.minChar(s));
	    }
	}
    
    public static class FastReader
	{
		BufferedReader br;
		StringTokenizer st;

		public FastReader()
		{
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer("");
		}

		private void read() throws IOException
		{
			st = new StringTokenizer(br.readLine());
		}

		public String nextString() throws IOException
		{
			while(!st.hasMoreTokens())
				read();
			return st.nextToken();
		}

		public int nextInt() throws IOException
		{
			return Integer.parseInt(nextString());
		}

		public long nextLong() throws IOException
		{
			return Long.parseLong(nextString());
		}
	}
}
// } Driver Code Ends