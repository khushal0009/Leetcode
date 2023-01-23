class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n == 1)return 1;
        if(trust.length ==0)return -1;
        boolean []know = new boolean [n+1];
        HashMap<Integer, Integer> hm = new HashMap<>();
         for(int i[]: trust){
               know[i[0]] = true;
         }
        for(int i[]: trust){
            hm.put(i[1], hm.getOrDefault(i[1], 0)+1);
            if(hm.get(i[1]) == n-1 && !know[i[1]]){
                return i[1];
            }
        }
        return -1;
    }
}