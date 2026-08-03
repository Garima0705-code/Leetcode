class Solution {
    public void permutation(int[] nums, List<List<Integer>> ans, List<Integer> list, boolean[] visit){

        if(list.size() == nums.length){
            ans.add(new ArrayList<>(list));
            return ;
        }
        for(int i = 0; i < nums.length; i++){
            if(visit[i]) continue ;
            int ele = nums[i];
            list.add(ele);
            visit[i] = true ;
            permutation(nums, ans, list, visit);
            visit[i] = false;
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visit = new boolean[nums.length];
        permutation(nums, ans, list, visit);
        return ans ;
    }
}