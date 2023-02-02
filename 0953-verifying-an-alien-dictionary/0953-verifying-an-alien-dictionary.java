class Solution {
    public boolean compare(String a, String b, String order){
        for(int i = 0; i < Math.min(a.length(), b.length()); i++) {
            if(order.indexOf(a.charAt(i)) == order.indexOf(b.charAt(i))) {
                
            }
            else if(order.indexOf(a.charAt(i)) > order.indexOf(b.charAt(i))) {
                return false;
            }
            else if(order.indexOf(a.charAt(i)) < order.indexOf(b.charAt(i))) {
                return  true;
            }
            
        }
        return a.length() <= b.length();
    }

    public boolean isAlienSorted(String[] words, String order) {
        boolean ans = true;
        for(int i = 0; i < words.length-1; i++) {
            ans = compare(words[i], words[i+1], order);
            if(ans == false)
                break;
        }
        return ans;
    }
}