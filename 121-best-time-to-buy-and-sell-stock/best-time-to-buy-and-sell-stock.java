class Solution {
    public int maxProfit(int[] arr) {
        int n = arr.length ;
        int maxPro = 0 ;
        int max = arr[n-1] ;
        for(int i = n-2 ; i >= 0 ; i--){
            int ele = arr[i] ;
            if(ele < max){
                int diff = max-ele ;
                maxPro = Math.max(maxPro,diff) ;
            }else{
                max = ele ;
            }
        }
        return maxPro ;
    }
}