class Solution {
    public void dfs(char[][] grid, int i , int j, boolean[][] visit){
        int m = grid.length ;
        int n = grid[0].length ;
        visit[i][j] = true ;
        if(i+1 < m && visit[i+1][j] == false && grid[i+1][j] == '1') dfs(grid,i+1,j,visit) ;
        if(j-1 >= 0 && visit[i][j-1] == false && grid[i][j-1] == '1') dfs(grid,i,j-1,visit) ;
        if(i-1 >= 0 && visit[i-1][j] == false && grid[i-1][j] == '1') dfs(grid,i-1,j,visit) ;
        if(j+1 < n && visit[i][j+1] == false && grid[i][j+1] == '1') dfs(grid,i,j+1,visit) ;
    }
    public int numIslands(char[][] grid) {
        int m = grid.length ;
        int n = grid[0].length ;
        boolean[][] visit = new boolean[m][n] ;
        int count = 0 ;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == '1' && visit[i][j] == false){
                    dfs(grid , i , j , visit) ;
                    count++ ;
                }
            }
        }
        return count ;
    }
}