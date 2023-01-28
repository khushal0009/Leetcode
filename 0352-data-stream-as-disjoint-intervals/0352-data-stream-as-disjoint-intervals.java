class SummaryRanges {
    boolean[] values;
    public SummaryRanges() {
        values=new boolean[10001];

    }
    
    public void addNum(int value) {
        values[value]=true;
        
    }
    
    public int[][] getIntervals() {
        int i=0,j;
        List<int[]> arrayList=new ArrayList<>();
        while(i<=10000){
            if(i<=10000 && values[i]){
                j=i+1;
                while(values[j]){
                    j++;
                }
                int[] array=new int[2];
                array[0]=i;
                array[1]=j-1;
                arrayList.add(array);
                
                i=j;
            }
            else i++;
        }
        int[][] ans=new int[arrayList.size()][2];
        i=0;

        for(int[] temp:arrayList){
             ans[i]=temp;
             i++;
        }
        return ans;   
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */