class Solution {
    public void backtrack(Integer n , List<List<Integer>> result , List<Integer> perm , Integer k , int idx){
        if(perm.size() == k){
            result.add(new ArrayList<>(perm)) ;
            return ;
        }
        for(int i = idx ; i <= n ; i++){
            if(perm.contains(i)) continue ;
            perm.add(i) ;
            backtrack(n , result , perm , k , i+1) ;
            perm.remove(perm.size()-1) ;
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>() ;
        backtrack(n , result , new ArrayList<>() , k , 1) ;
        return result ;
    }
}