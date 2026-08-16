class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a,b)->Integer.compare(a[1], b[1])) ;
        List<int[]> list = new ArrayList<>() ;
        list.add(pairs[0]) ;
        for(int i = 1 ; i < pairs.length; i++){
            int x = list.get(list.size()-1)[1] ;
            if(x < pairs[i][0]){
                list.add(pairs[i]) ;
            }
        }
        return list.size() ;
    }
}