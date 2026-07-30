class Solution {
    public int count(String a, String b, int i, int j, int[][] dp) {
        if(i < 0 && j < 0) return 0 ;
        if(i < 0) return j+1 ;
        if(j < 0) return i+1 ;
        if(dp[i][j] != -1) return dp[i][j] ;
        if(a.charAt(i) == b.charAt(j)) return dp[i][j] = count(a,b,i-1,j-1, dp) ;
        else{
            int delete = 1 + count(a, b, i-1, j, dp);
            int replace = 1 + count(a, b, i-1, j-1, dp);
            int insert = 1 + count(a, b, i, j-1, dp);
            return dp[i][j] = Math.min(delete , Math.min(replace,insert)) ;
        }
    }
    public int minDistance(String word1, String word2) {
        int m = word1.length() ;
        int n = word2.length() ;
        int[][] dp = new int[m][n] ;
        for(int i = 0 ; i < m ; i++) Arrays.fill(dp[i],-1) ;
        return count(word1 , word2, m-1 , n-1, dp);
    }
}