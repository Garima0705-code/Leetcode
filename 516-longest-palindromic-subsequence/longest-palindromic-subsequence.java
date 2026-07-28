class Solution {
    public int lps(StringBuilder s, int i, int j , int[][] dp) {
        if(i > j) return 0 ;
        if(dp[i][j] != -1) return dp[i][j] ;
        if(i == j) return dp[i][j] = 1 ; 
        if(s.charAt(i) == s.charAt(j)) return dp[i][j] = 2 + lps(s, i+1, j-1, dp) ;
        else{
            return dp[i][j] = Math.max(lps(s, i, j-1, dp) , lps(s, i+1, j, dp)) ;
        }
    }
    public int longestPalindromeSubseq(String s) {
        StringBuilder a = new StringBuilder(s) ;
        int m = a.length() ;
        int[][] dp = new int[m][m] ;
        for(int i = 0 ; i < m ; i++)
        Arrays.fill(dp[i] , -1) ;
        return lps(a , 0 , m-1, dp) ;
    }
}