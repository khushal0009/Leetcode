class Solution { 
void comb(int ind, int[]arr, int tar, List<Integer> al, List<List<Integer>> res){
    if(tar==0){
        res.add(new ArrayList<>(al));
        return;
    }
    
    for(int i=ind; i<arr.length; i++){
        if(i>ind && arr[i]==arr[i-1]){
            continue;
        }
        
        if(arr[i]>tar){
            break;
        }
        
        al.add(arr[i]);
        comb(i+1, arr, tar-arr[i], al, res);
        al.remove(al.size()-1);
    }
}

public List<List<Integer>> combinationSum2(int[] arr, int target) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> al = new ArrayList<>();
    
    Arrays.sort(arr);
    
    comb(0, arr, target, al, res);
    
    return res;
}
}