class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length ;
        int min = Integer.MAX_VALUE ;
        int mindx = -1 ;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] < 0 && k > 0){
                nums[i] *= -1 ;
                k--;
            }
            if(nums[i] < min){
                min = nums[i];
                mindx = i ;
            }
        }
        if(k > 0 && k % 2 != 0) nums[mindx] *= -1 ;
        int sum = 0 ;
        for(int i = 0 ; i < n ; i++){
            sum += nums[i];
        }
        return sum;
    }
}