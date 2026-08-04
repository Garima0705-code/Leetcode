class Solution {
    public boolean check(int[][] grid, int row, int col, int n){
        int m = grid.length;
        if(n == m*m) return true ;
        //DR
        if(row+2 < m && col+1 < m && grid[row+2][col+1] == n) return check(grid, row+2, col+1, n+1);
        //DL
        else if(row+2 < m && col-1 >= 0 && grid[row+2][col-1] == n) return check(grid, row+2, col-1, n+1);
        //UR
        else if(row-2 >= 0 && col+1 < m && grid[row-2][col+1] == n) return check(grid, row-2, col+1, n+1);
        //UL
        else if(row-2 >= 0 && col-1 >= 0 && grid[row-2][col-1] == n) return check(grid, row-2, col-1, n+1);
        //RU
        else if(row-1 >= 0 && col+2 < m && grid[row-1][col+2] == n) return check(grid, row-1, col+2, n+1);
        //RD
        else if(row+1 < m && col+2 < m && grid[row+1][col+2] == n) return check(grid, row+1, col+2, n+1);
        //LU
        else if(row-1 >= 0 && col-2 >= 0 && grid[row-1][col-2] == n) return check(grid, row-1, col-2, n+1);
        //LD
        else if(row+1 < m && col-2 >= 0 && grid[row+1][col-2] == n) return check(grid, row+1, col-2, n+1);
        else return false;
    }
    public boolean checkValidGrid(int[][] grid) {
        if(grid[0][0] != 0) return false;
        return check(grid, 0, 0, 1);
    }
}