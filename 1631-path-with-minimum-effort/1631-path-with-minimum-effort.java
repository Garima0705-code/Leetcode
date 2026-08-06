class Solution {
    public class Triplet implements Comparable<Triplet>{
        int row ;
        int col;
        int val ;
        Triplet(int row, int col, int val){
            this.row = row ;
            this.col = col ;
            this.val = val ;
        }
        public int compareTo(Triplet t){
            return this.val-t.val;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length ;
        int n = heights[0].length ;
        int[][] ans = new int[m][n];
        for(int i = 0 ; i < m ; i++) Arrays.fill(ans[i] , Integer.MAX_VALUE) ;
        ans[0][0] = 0;
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        pq.add(new Triplet(0,0,0));
        while(pq.size() > 0){
            Triplet t = pq.remove();
            int row = t.row ;
            int col = t.col;
            int val = t.val ;
            if(row-1 >= 0){
                int up = Math.abs(heights[row-1][col] - heights[row][col]);
                int max = Math.max(up , val);
                if(max < ans[row-1][col]){
                    ans[row-1][col] = max ;
                    pq.add(new Triplet(row-1, col, max)) ;
                }
            }
            if(row+1 < m){
                int down = Math.abs(heights[row+1][col] - heights[row][col]) ;
                int max = Math.max(down , val);
                if(max < ans[row+1][col]){
                    ans[row+1][col] = max ;
                    pq.add(new Triplet(row+1, col, max)) ;
                }
            }
            if(col-1 >= 0){
                int left = Math.abs(heights[row][col-1] - heights[row][col]) ;
                int max = Math.max(left , val);
                if(max < ans[row][col-1]){
                    ans[row][col-1] = max ;
                    pq.add(new Triplet(row, col-1, max)) ;
                }
            }
            if(col+1 < n){
                int right = Math.abs(heights[row][col+1] - heights[row][col]) ;
                int max = Math.max(right , val);
                if(max < ans[row][col+1]){
                    ans[row][col+1] = max ;
                    pq.add(new Triplet(row, col+1, max)) ;
                }
            }
        }
        return ans[m-1][n-1];
    }
}