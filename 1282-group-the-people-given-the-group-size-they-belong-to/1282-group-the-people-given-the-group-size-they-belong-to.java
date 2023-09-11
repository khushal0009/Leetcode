class Solution {
    public List<List<Integer>> groupThePeople(int[] arr) {
        List<List<Integer>>ans=new ArrayList<>();
        TreeMap<Integer,ArrayList<Integer>>map=new TreeMap<>();
        for(int i=0;i<arr.length;i++){
            ArrayList<Integer>ll=map.getOrDefault(arr[i],new ArrayList<>());
            ll.add(i);
            map.put(arr[i],ll);
        }
        for(Map.Entry<Integer,ArrayList<Integer>>e:map.entrySet()){
            int k=e.getKey();
            ArrayList<Integer>list=new ArrayList<>(e.getValue());
            if(list.size()==k){
                ans.add(list);
            }
            else{
                while(list.size()!=0){
                    ArrayList<Integer>l=new ArrayList<>();
                    for(int i=0;i<k;i++){
                        l.add(list.get(0));
                        list.remove(0);
                    }
                    ans.add(l);
                }
            }
        }
        return ans;
    }
}