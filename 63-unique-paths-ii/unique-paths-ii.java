class Solution {
    public int path(int[][] ob ,int m , int n , int row , int col , int[][] dp){
        if(row >= m || col >= n) return 0 ;
        if(row == m-1 && col == n-1) return 1 ;
        if(ob[row][col] == 1) return 0 ;
        if(dp[row][col] != -1) return dp[row][col] ;
        int down = 0 , right = 0 ;
        right = path(ob , m , n , row , col+1 , dp) ;
        down = path(ob , m , n , row+1 , col , dp) ;
        return dp[row][col] = right+ down ;
    }
    public int uniquePathsWithObstacles(int[][] obs) {
        int m = obs.length ;
        int n = obs[0].length ;
        if(obs[0][0] == 1 || obs[m-1][n-1] == 1) return 0 ;
        int[][] dp = new int[m][n] ;
        for(int i = 0 ; i < m ; i++) Arrays.fill(dp[i] , -1) ;
        return path(obs , m , n , 0 , 0 , dp) ;
    }
}