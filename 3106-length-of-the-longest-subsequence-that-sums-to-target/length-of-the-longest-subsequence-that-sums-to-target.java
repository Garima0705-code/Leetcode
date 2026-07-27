class Solution {
    public int lengthCount(List<Integer> nums, int target, int idx, int[][] dp) {
        if(nums.size() == idx){
            if(target == 0) return 0 ;
            return Integer.MIN_VALUE ;
        }
        if(dp[idx][target] != -1) return dp[idx][target] ;
        int skip = lengthCount(nums , target , idx+1 , dp) ;
        if(target-nums.get(idx) < 0) return dp[idx][target] = skip ;
        int pick = 1+lengthCount(nums , target-nums.get(idx) , idx+1 , dp) ;
        return dp[idx][target] = Math.max(skip , pick) ;
    }

    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n = nums.size() ;
        int[][] dp = new int[n][target+1] ;
        for(int i = 0 ; i < n ; i++) Arrays.fill(dp[i] , -1) ;
        int ans = lengthCount(nums , target , 0 , dp) ;
        if(ans < 0) return -1 ;
        return ans ;
    }
}