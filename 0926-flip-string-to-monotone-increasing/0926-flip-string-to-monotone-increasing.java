class Solution {
    public int minFlipsMonoIncr(String s) {
        int oneCount=0,zeroToOne=0;
        int i=0;
        while(i<s.length() && s.charAt(i)=='0'){
            i++;
        }
        for(;i<s.length();i++){
            if(s.charAt(i)=='0'){
                zeroToOne++;
            }
            else{
                oneCount++;
            }
            if(oneCount<zeroToOne){
               zeroToOne= oneCount;
            }
        }
        return zeroToOne;
    }
}