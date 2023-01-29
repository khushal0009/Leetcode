class LFUCache {

    private Map<Integer,Integer> count;
    private Map<Integer,Integer> values;
    private Map<Integer, LinkedHashSet<Integer>> map;

    private int currentCapacity;
    private int capacity;

    private int minFrequency=Integer.MAX_VALUE;
    public LFUCache(int capacity) {
        this.capacity=capacity;
        count=new HashMap<>(capacity);
        map=new HashMap<>();
        values=new HashMap<>();
    }

    public int get(int key) {

        LinkedHashSet<Integer> list;
       if(values.containsKey(key)){
           int res = values.get(key);
           int f = count.get(key);
           count.put(key,f+1);
           list = map.get(f);

           list.remove(key);
           if(list.size()==0){
               map.remove(f);
               if(f==minFrequency){
                   minFrequency++;
               }
           }else{
               map.put(f,list);
           }

           if(map.containsKey(f+1)){
               list = map.get(f+1);
           }else{
               list = new LinkedHashSet<>();
           }
           list.add(key);

           map.put(f+1,list);

           return res;
       }
        return -1;
    }
    


    public void put(int key, int value) {
        if(values.containsKey(key)){
            values.put(key,value);
            get(key);
            return;
        }

        if(capacity==0){
            return;
        }

        if(currentCapacity+1>capacity){
            LinkedHashSet<Integer> list = map.get(minFrequency);
            int elementToRemove = list.iterator().next();
            list.remove(elementToRemove);
            if(list.isEmpty()){
                map.remove(minFrequency);
             map.put(1,list);
            }

            list = new LinkedHashSet<>();
            if(map.containsKey(1)){
                list = map.get(1);
            }
            list.add(key);
            map.put(1,list);

            count.remove(elementToRemove);
            values.remove(elementToRemove);
            values.put(key,value);
            count.put(key,1);

        }else{
            values.put(key,value);
            count.put(key,1);
            LinkedHashSet<Integer> list = map.get(1);
            if(list==null){
                list = new LinkedHashSet<>();
                list.add(key);
            }else{
                list.add(key);
            }

            map.put(1,list);
            currentCapacity++;
        }

        minFrequency=1;

    }
}