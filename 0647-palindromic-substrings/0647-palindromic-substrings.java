class Solution {
    public int countSubstrings(String s) {
        int m = s.length();
        int[][] dp = new int[m][m];
        int count = 0;
        for(int k = 0 ; k < m; k++){
            int i = 0 , j = k ;
            while(j < m){
                if(i == j){
                    dp[i][j] = 1 ;
                    count ++;
                }
                else if(i+1 == j){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = 1 ;
                        count ++;
                    }
                }
                else{
                    if(s.charAt(i) == s.charAt(j)){
                        if(dp[i+1][j-1] == 1){
                            dp[i][j] = 1 ;
                            count ++;
                        }
                    }
                }
                i++ ; j++;
            }
        }
        return count;
    }
}