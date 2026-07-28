class Solution {
    public int steps(String s , int i , int j, int[][] dp) {
        if(i > j) return 0 ;
        if(dp[i][j] != -1) return dp[i][j] ;
        if(i==j) return dp[i][j]=1 ;
        if(s.charAt(i) == s.charAt(j)) return dp[i][j] = 2 +  steps(s,i+1,j-1,dp);
        else{
           return dp[i][j] = Math.max(steps(s,i+1,j,dp) , steps(s,i,j-1,dp));
        }
    }
    public int minInsertions(String s) {
        int n = s.length() ;
        int[][] dp = new int[n][n] ;
        for(int i = 0 ; i < n ; i++) Arrays.fill(dp[i],-1) ;
        int len = steps(s,0,n-1,dp);
        return n-len ;
    }
}