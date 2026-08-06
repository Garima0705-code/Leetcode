class Solution {
    public String longestPalindrome(String s) {
        int m = s.length();
        int[][] dp = new int[m][m];
        int row = -1, col = -1;
        for(int k = 0 ; k < m; k++){
            int i = 0 , j = k ;
            while(j < m){
                if(i == j){
                    dp[i][j] = 1 ;
                    row = i ; col = j;
                }
                else if(i+1 == j){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = 1 ;
                        row = i ; col = j;
                    }
                }
                else{
                    if(s.charAt(i) == s.charAt(j)){
                        if(dp[i+1][j-1] == 1){
                            dp[i][j] = 1 ;
                            row = i ; col = j;
                        }
                    }
                }
                i++ ; j++;
            }
        }
        return s.substring(row, col+1);
    }
}
