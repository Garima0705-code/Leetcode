class Solution {
    public int[][] merge(int[][] arr) {
        Arrays.sort(arr , (a,b)-> Integer.compare(a[0],b[0])) ;
        List<List<Integer>> ans = new ArrayList<>() ;
        ans.add(new ArrayList<>()) ;
        ans.get(0).add(arr[0][0]) ;
        ans.get(0).add(arr[0][1]) ;
        for(int i = 1 ; i < arr.length ; i++){
            int x = ans.get(ans.size()-1).get(1);
            int y = arr[i][0] ;
            if(x >= y){
                ans.get(ans.size()-1).set(1, Math.max(x, arr[i][1])) ;
            }else{
                List<Integer> list = new ArrayList<>() ;
                list.add(arr[i][0]) ;
                list.add(arr[i][1]) ;
                ans.add(list) ;
            }
        }
        int n = ans.size() ;
        int[][] ans2 = new int[n][2] ;
        for(int i = 0 ; i < n ; i++){
            ans2[i][0] = ans.get(i).get(0) ;
            ans2[i][1] = ans.get(i).get(1) ;
        }
        return ans2 ;
    }
}