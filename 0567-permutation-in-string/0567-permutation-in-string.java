class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
// If the first string is longer it can't contain 
// a permutation of the second
        if(len1>len2) return false;
// If the first string is contained within the second 
// a permutation exists in the second too
        if(s2.contains(s1)) return true;
// Initialize a queue to hold all removed characters from s1
        Queue<Character> queue = new LinkedList<>();
        for(int i = 0; i < len2; i++) {
// If s1 currently doesn't contain the current character in s2
            if(!s1.contains(""+s2.charAt(i))) {
// If the queue isn't empty, then s1 already had character(s) removed
                if(!queue.isEmpty()) {
// Add back the first removed character to s1 and start checking 
// from the same index again
                    s1 += ""+queue.remove();
                    i--;
                }
                continue;
            }
            else {
// Remove the currently being checked character from s1 
// and add it to the queue
                s1 = s1.replaceFirst(""+s2.charAt(i), "");
                queue.add(s2.charAt(i));
            }
// If all characters have been removed from s1 then there is an
// unbroken sequence/ permutation of s1 that exists in s2
            if(s1.length()==0) return true;
        }
        return s1.length()==0;
    }
}