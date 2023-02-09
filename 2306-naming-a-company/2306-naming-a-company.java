class Solution {
    public long distinctNames(String[] ideas) {
        long ans = 0;
        List<Set<String>> list = new ArrayList<>();
        for(int i=0;i<26;i++){
            list.add(new HashSet<>());
        }
        for(String s  : ideas){
            char f = s.charAt(0);
            list.get((int)f-(int)'a').add(s.substring(1,s.length()));
        }
        for(int i=0;i<25;i++){
            long count1=0;
            long count2 =0;
            for(int j=i+1;j<26;j++){
                count1 = 0;
                count2 = 0;
                for(String e1 : list.get(i)){
                    if(!list.get(j).contains(e1)) count1++;
                }
                for(String e2 : list.get(j)){
                    if(!list.get(i).contains(e2)) count2++;
                }
                ans += (count1*count2);
            }
        }
        return 2*ans ;
    }
}