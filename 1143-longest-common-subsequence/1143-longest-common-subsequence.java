class Solution {
    public int lcs(String s1, String s2, int si, int sj, int[][] dp) {
        if(si < 0 || sj < 0) return 0 ;
        if(dp[si][sj] != -1) return dp[si][sj] ;
        if(s1.charAt(si) == s2.charAt(sj)){
            return dp[si][sj] = 1 + lcs(s1 , s2 , si-1 , sj-1, dp) ;
        }else{
            return dp[si][sj] = Math.max(lcs(s1 , s2 , si-1 , sj, dp) , lcs(s1 , s2 , si , sj-1, dp)) ;
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length() ;
        int n = text2.length() ;
        int[][] dp = new int[m][n] ;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(text1.charAt(i) == text2.charAt(j)){
                    int z = (i <= 0 || j <= 0) ? 0 : dp[i-1][j-1] ;
                    dp[i][j] = 1 + z ;
                }else{
                    int x = (i <= 0) ? 0 : dp[i-1][j] ;
                    int y = (j <= 0) ? 0 : dp[i][j-1] ;
                    dp[i][j] = Math.max(x , y) ;
                }
            }
        }
        return dp[m-1][n-1];
    }
}