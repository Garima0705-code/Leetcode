class Solution {
    public boolean isequal(int[] arr , int idx , int target , int[][] dp){
        if(idx == arr.length) return (target == 0) ;
        if(dp[idx][target] != -1) return (dp[idx][target] == 1) ;
        boolean ans = false ;
        boolean skip = isequal(arr , idx+1 , target , dp) ;
        if(target-arr[idx] < 0) ans = skip ;
        else{
            boolean pick = isequal(arr , idx+1 , target-arr[idx] , dp) ;
            ans = pick || skip ;
        }
        dp[idx][target] = ans ? 1 : 0 ;
        return ans ;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0 ;
        for(int ele : nums) sum += ele ;
        if(sum%2 != 0) return false ;
        int[][] dp = new int[nums.length][sum/2+1] ;
        for(int i = 0 ; i < nums.length ; i++) Arrays.fill(dp[i],-1) ;
        return isequal(nums , 0 , sum/2 , dp) ;
    }
}