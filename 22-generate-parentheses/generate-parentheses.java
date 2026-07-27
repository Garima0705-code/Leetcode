class Solution {
    public void generate(int n, String s, int open, int close, List<String> ans){
        if(s.length() == 2*n){
            ans.add(s) ;
            return ;
        }
        if(open < n) generate(n, s+"(", open+1, close, ans) ;
        if(close < open) generate(n, s+")", open, close+1, ans) ;
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>() ;
        generate(n, "", 0, 0, ans) ;
        return ans ;
    }
}