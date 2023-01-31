class Solution {
    public int repeatedStringMatch(String a, String b) {
        // Method 1:
        // int count = 1;
        // int n = b.length()/a.length();
        // String str = a;
        // for(int i=0;i<n+2;i++){
        //     if(a.contains(b)){
        //         return count;
        //     }
        //     else{
        //         a += str;
        //         count++;
        //     }
        // }
        // return -1;

//Method 2: keep adding "a" till reaches to size of "b" and increment count.
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while(sb.length() < b.length()){
            sb.append(a);
            count++;
        }
        if(sb.toString().contains(b))
            return count;
        if(sb.append(a).toString().contains(b))
            return ++count;
        return -1;

    }
}