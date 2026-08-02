class Solution {
    public int ways(int[][] grid, int si, int sj, int m , int n, int count){
        if(si < 0 || sj < 0) return 0;
        if(si > m || sj > n) return 0;
        if(grid[si][sj] == 2 && count == 1) return 1 ;
        if(grid[si][sj] == -1) return 0;
        if(grid[si][sj] == -4) return 0;
        int temp = grid[si][sj];
        grid[si][sj] = -4 ;
        int right = ways(grid, si, sj+1, m, n, count-1);
        int left = ways(grid, si, sj-1, m, n, count-1);
        int down = ways(grid, si+1, sj, m, n, count-1);
        int up =ways(grid, si-1, sj, m, n, count-1);
        grid[si][sj] = temp ;
        return right+ left + down + up ;
    }
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length ;
        int n = grid[0].length ;
        int si = 0 ;
        int sj = 0 ;
        int count = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == -1) continue ;
                if(grid[i][j] == 1){
                    si = i;
                    sj = j;
                }
                count ++ ;
            }
        }
        return ways(grid, si, sj, m-1, n-1, count);
    }
}