class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->{
            if(a[1] == b[1]) return Integer.compare(a[0],b[0]) ;
            return Integer.compare(a[1],b[1]) ;
        });
        int count = 0 ;
        List<List<Integer>> ans = new ArrayList<>() ;
        ans.add(new ArrayList<>()) ;
        ans.get(0).add(intervals[0][0]) ;
        ans.get(0).add(intervals[0][1]) ;
        for(int i = 1 ; i < intervals.length ; i++){
            int x = ans.get(ans.size()-1).get(0) ;
            int y = ans.get(ans.size()-1).get(1) ;
            if(x == intervals[i][0] || y > intervals[i][0]) count++ ;
            else{
                List<Integer> list = new ArrayList<>() ;
                list.add(intervals[i][0]) ;
                list.add(intervals[i][1]) ;
                ans.add(list) ;
            }
        }
        return count ;
    }
}