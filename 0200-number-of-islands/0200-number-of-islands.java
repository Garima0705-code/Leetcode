class Solution {
    class Pair{
        int i , j ;
        Pair(int i , int j){
            this.i = i ;
            this.j = j ;
        }
    }
    public void bfs(char[][] grid , boolean[][] visited , int i , int j){
        int m = grid.length ;
        int n = grid[0].length ;
        Queue<Pair> q = new LinkedList<>() ;
        q.add(new Pair(i , j)) ;
        while(q.size() > 0){
            Pair p = q.remove() ;
            int row = p.i ;
            int col = p.j ;
            if(col+1 < n && grid[row][col+1] == '1' && !visited[row][col+1]){
                visited[row][col+1] = true ;
                q.add(new Pair(row , col+1)) ;
            }
            if(row+1 < m && grid[row+1][col] == '1' && !visited[row+1][col]){
                visited[row+1][col] = true ;
                q.add(new Pair(row+1 , col)) ;
            }
            if(col-1 >= 0 && grid[row][col-1] == '1' && !visited[row][col-1]){
                visited[row][col-1] = true ;
                q.add(new Pair(row , col-1)) ;
            }
            if(row-1 >= 0 && grid[row-1][col] == '1' && !visited[row-1][col]){
                visited[row-1][col] = true ;
                q.add(new Pair(row-1 , col)) ;
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length ;
        int n = grid[0].length ;
        boolean[][] visited = new boolean[m][n] ;
        int count = 0 ;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    visited[i][j] = true ;
                    bfs(grid ,visited , i , j) ;
                    count++ ;
                }
            }
        }
        return count ;
    }
}