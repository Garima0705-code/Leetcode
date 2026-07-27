class Solution {
    public void backtrack(int[] nums , List<List<Integer>> result , List<Integer> perm){
        if(perm.size() == nums.length){
            result.add(new ArrayList<>(perm)) ;
            return ;
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(perm.contains(nums[i])) continue ;
            perm.add(nums[i]) ;
            backtrack(nums , result , perm) ;
            perm.remove(perm.size()-1) ;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>() ;
        backtrack(nums , result , new ArrayList<>()) ;
        return result ;
    }
}