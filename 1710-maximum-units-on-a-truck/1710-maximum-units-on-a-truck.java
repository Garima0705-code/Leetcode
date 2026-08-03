class Solution {
    public int maximumUnits(int[][] arr, int size) {
        Arrays.sort(arr , (a,b)-> Integer.compare(a[1], b[1]));
        int m = arr.length ;
        int units = 0 ;
        for(int i = m-1 ; i >= 0 ; i--){
            if(size > arr[i][0]){
                size -= arr[i][0];
                units += (arr[i][1]*arr[i][0]);
            }else{
                units += (arr[i][1]*size);
                break;
            }
        }
        return units;
    }
}