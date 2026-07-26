class Solution {
    public long coinCount(int[] coins, int amount , int idx , long[][] dp) {
        if(idx == coins.length){
            if(amount == 0) return 0 ;
            return Integer.MAX_VALUE ;
        }
        if(dp[idx][amount] != -1) return dp[idx][amount] ;
        long skip = coinCount(coins , amount , idx+1 , dp) ;
        if(amount-coins[idx] < 0) return dp[idx][amount] = skip ;
        long pick = 1 + coinCount(coins , amount-coins[idx] , idx , dp) ;
        return dp[idx][amount] = Math.min(skip,pick) ;
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length ;
        long[][] dp = new long[n][amount+1] ;
        for(int i = 0 ; i < n ; i++) Arrays.fill(dp[i] , -1) ;
        int ans = (int)coinCount(coins , amount , 0 , dp) ;
        if(ans == Integer.MAX_VALUE) return -1 ;
        return ans ;
    }
}