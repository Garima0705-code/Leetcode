class Solution {
    public int countSquares(int[][] arr) {
        int m = arr.length ;
        int n = arr[0].length ;
        int count = 0;
        for(int i = 1 ; i < m ;i++){
            for(int j = 1 ; j < n ; j++){
                if(arr[i][j] == 1)
                arr[i][j] += Math.min(arr[i-1][j-1] , Math.min(arr[i][j-1] , arr[i-1][j])) ;
            }
        }
        for(int[] brr : arr){
            for(int ele : brr) count += ele ;
        }
        return count ;
    }
}