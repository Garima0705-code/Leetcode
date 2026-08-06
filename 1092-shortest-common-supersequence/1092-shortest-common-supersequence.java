class Solution {
    public String lcs(String s, String t){
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 1 ; i <= m ; i++){
            for(int j = 1 ; j <= n ; j++){
                if(s.charAt(i-1) == t.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        StringBuilder a = new StringBuilder();
        int i = m ;
        int j = n;
        while(j > 0 && i > 0){
            if(s.charAt(i-1) == t.charAt(j-1)){
                a.append(s.charAt(i-1));
                i--; j--;
            }
            else{
                if(dp[i][j-1] > dp[i-1][j]) j--;
                else i--;
            }
        }
        a.reverse();
        return a.toString();
    }
    public String shortestCommonSupersequence(String a, String b) {
        String ans = lcs(a, b);
        int i = 0;
        int j = 0;
        int k = 0;
        String s = "";
        while(k < ans.length()){
            while(a.charAt(i) != ans.charAt(k)){
                s += a.charAt(i);
                i++;
            } 
            while(b.charAt(j) != ans.charAt(k)){
                s += b.charAt(j);
                j++;
            } 
            s += ans.charAt(k);
            k++; i++; j++;
        }
        if(j < b.length())
            s += b.substring(j);
        if(i < a.length())
            s += a.substring(i);
        return s;
    }
}