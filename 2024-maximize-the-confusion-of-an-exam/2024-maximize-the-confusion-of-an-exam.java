class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
       return Math.max(f(answerKey,k,'T'),f(answerKey,k,'F'));
   
                     
        
    }
    int f(String s,int k ,char key){
        int k1=k;
        int i=0,j=0;
        int ans=0;
        while(j<s.length()){
           
            if(s.charAt(j)!=key){
                if(k1>0){
                    k1--;
                }else{
                    
                    ans=Math.max(ans,j-i);
                    
                    while(s.charAt(i)==key){
                        i++;
                       
                    }
                    i+=1;
                   
                    
                }
            }
            j++;
        }
        ans=Math.max(ans,j-i);
        
        return ans;
    }
}