class Solution {
    public int count(int m, int n , int row , int col , int[][] dp){
        if(row == m-1 || col == n-1) return 1 ;
        if(dp[row][col] != -1) return dp[row][col] ;
        return dp[row][col] = count(m , n , row+1 , col , dp) + count(m , n , row , col+1 , dp) ;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n] ;
        for(int i = 0 ; i < m ; i++) Arrays.fill(dp[i] , -1) ;
        return count(m , n , 0 , 0 , dp) ;
    }
}