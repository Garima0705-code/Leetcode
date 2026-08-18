class Solution {
    public int maxProfit(int[] arr) {
        int n = arr.length ;
        int maxPro = 0 ;
        int[] ans = new int[n] ;
        int max = arr[n-1] ;
        for(int i = n-2 ; i >= 0 ; i--){
            if(arr[i] < max){
                int diff = max-arr[i] ;
                ans[i] = Math.max(diff,ans[i]) ;
            }else{
                max = arr[i] ;
            }
            maxPro = Math.max(maxPro,ans[i]) ;
        }
        return maxPro ;
    }
}