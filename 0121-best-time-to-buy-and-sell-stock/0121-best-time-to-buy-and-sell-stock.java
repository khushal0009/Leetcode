class Solution {
    public int maxProfit(int[] arr) {
        int[] aux = new int[arr.length]; 
        int profit = 0;
        aux[0] = arr[0];
        for(int i = 1 ; i < arr.length ; i++)
           aux[i] = Math.min(arr[i], aux[i-1]);
        for(int i = 0 ; i < arr.length ; i++)
            profit = Math.max(profit, arr[i] - aux[i]);
        return profit;
    }
}