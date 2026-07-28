class Solution {
    public int lcs(String s1, String s2, int si, int sj, int[][] dp) {
        if(si < 0 || sj < 0) return 0 ;
        if(dp[si][sj] != -1) return dp[si][sj] ;
        if(s1.charAt(si) == s2.charAt(sj)){
            return dp[si][sj] = 1 + lcs(s1 , s2 , si-1 , sj-1, dp) ;
        }else
            return dp[si][sj] = Math.max(lcs(s1 , s2 , si-1 , sj, dp) , lcs(s1 , s2 , si , sj-1, dp)) ;
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length() ;
        int n = text2.length() ;
        int[][] dp = new int[m][n] ;
        for(int i = 0 ; i < m ; i++)
        Arrays.fill(dp[i] , -1) ;
        return lcs(text1 , text2 , m-1 , n-1 , dp) ;
    }
    public int minDistance(String word1, String word2) {
        int ans = longestCommonSubsequence(word1 , word2) ;
        int m = word1.length() ;
        int n = word2.length() ; 
        return m-ans + n-ans ;
    }
}