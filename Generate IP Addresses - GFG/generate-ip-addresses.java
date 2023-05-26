//{ Driver Code Starts
import java.util.*;
class GenIP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution sln = new Solution();
            ArrayList<String> str = sln.genIp(s);
            Collections.sort(str);
            if(str.size() == 0)
                System.out.println(-1);
            else{
                for (String u : str) {
                    System.out.println(u);
                }
            }
        }
    }
}
// } Driver Code Ends


/*complete the Function*/

class Solution {
    public ArrayList<String> genIp(String s) {
        // code here
        ArrayList<String> res=new ArrayList<String>();
        int len=s.length();
        StringBuffer ip=new StringBuffer();
        
        for(int aLen=1;aLen<=3;aLen++){
            for(int bLen=1;bLen<=3;bLen++){
                for(int cLen=1;cLen<=3;cLen++){
                    int dLen=len-(aLen+bLen+cLen);
                    
                    if(dLen>0 && dLen<=3){
                        int A=Integer.parseInt(s.substring(0,aLen));
                        int B=Integer.parseInt(s.substring(aLen,aLen+bLen));
                        int C=Integer.parseInt(s.substring(aLen+bLen,aLen+bLen+cLen));
                        int D=Integer.parseInt(s.substring(aLen+bLen+cLen));
                        
                        if(A<=255 && B<=255 && C<=255 && D<=255){
                            ip.append(A).append(".").append(B).append(".").append(C).append(".").append(D);
                            
                            
                            if(ip.length()==len+3){
                                res.add(ip.toString());
                                
                            }
                            ip=new StringBuffer();
                        }
                    }
                }
            }
        }
        return res;
    }
}