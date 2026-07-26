class Solution {
    public boolean isperfect(int n){
        int sqrt = (int)Math.sqrt(n) ;
        return (sqrt* sqrt == n) ;
    }
    public int count(int n , int[] dp){
        if(isperfect(n)) return 1 ;
        if(dp[n] != -1) return dp[n] ;
        int min = Integer.MAX_VALUE ;
        for(int i = 1 ; i*i <= n ; i++){
            int sum = count(i*i,dp) + count(n-i*i,dp) ;
            min = Math.min(sum , min) ;
        }
        return dp[n] = min ;
    }
    public int numSquares(int n) {
        int[] dp = new int[n+1] ;
        Arrays.fill(dp,-1) ;
        return count(n , dp) ;
    }
}