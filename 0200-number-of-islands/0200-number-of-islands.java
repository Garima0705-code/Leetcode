class Pair{
    int row ;
    int col ;
    Pair(int row , int col){
        this.row = row ;
        this.col = col ;
    }
}
class Solution {
    public void bfs(char[][] grid, boolean[][] visit, int r, int c){
        int m = grid.length ;
        int n = grid[0].length ;
        visit[r][c] = true ;
        Queue<Pair> q = new LinkedList<>() ;
        q.add(new Pair(r , c)) ;
        while(q.size() > 0){
            Pair box = q.remove() ;
            int row = box.row ;
            int col = box.col ;
            if(col > 0 && grid[row][col-1] == '1' && !visit[row][col-1]){
                visit[row][col-1] = true ;
                q.add(new Pair(row,col-1)) ;
            }
            if(col+1 < n && grid[row][col+1] == '1' && !visit[row][col+1]){
                visit[row][col+1] = true ;
                q.add(new Pair(row,col+1)) ;
            }
            if(row +1 < m && grid[row+1][col] == '1' && !visit[row+1][col]){
                visit[row+1][col] = true ;
                q.add(new Pair(row+1,col)) ;
            }
            if(row > 0 && grid[row-1][col] == '1' && !visit[row-1][col]){
                visit[row-1][col] = true ;
                q.add(new Pair(row-1,col)) ;
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length ;
        int n = grid[0].length ;
        boolean[][] visit = new boolean[m][n] ;
        int count = 0 ;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == '1' && !visit[i][j]){
                    bfs(grid,visit,i,j);
                    count++ ;
                }
            }
        }
        return count ;
    }
}