class Solution {
    public void generate(int n, List<String> ans, String s){
        if(s.length() == n){
            ans.add(s) ;
            return ;
        }
        if(s.length() ==0 || s.charAt(s.length()-1) == '1'){
            generate(n, ans, s+0) ;
            generate(n, ans, s+1) ;
            
        } 
        else{
            generate(n, ans, s+1) ;
        }
    }
    public List<String> validStrings(int n) {
        List<String> ans = new ArrayList<>() ;
        generate(n , ans , "") ;
        return ans ;
    }
}