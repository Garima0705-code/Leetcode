class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length ;
        int[] dp = new int[n] ;
        for(int i = 0 ; i < n; i++){
            int max = 0 ;
            dp[i] = 1;
            for(int j = i-1; j >= 0 ; j--){
                if(nums[j] < nums[i]){
                    max = Math.max(max , dp[j]) ;
                }
            }
            dp[i] += max ;
        }
        int[] dp1 = new int[n] ;
        for(int i = n-1 ; i >= 0; i--){
            int max = 0 ;
            dp1[i] = 1;
            for(int j = i+1; j < n ; j++){
                if(nums[j] < nums[i]){
                    max = Math.max(max , dp1[j]) ;
                }
            }
            dp1[i] += max ;
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            if(dp[i] <= 1 || dp1[i] <= 1) continue ;
            dp[i] += (dp1[i]-1) ;
            max = Math.max(max, dp[i]) ;
        }
        return n - max ;
    }
}