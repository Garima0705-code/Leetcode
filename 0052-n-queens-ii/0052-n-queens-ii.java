class Solution {
    public void nqueens(char[][] board, int[] ans, int row){
        int n = board.length;
        if(n == row){
            ans[0]++;
            return;
        }
        for(int j = 0 ; j < n ; j++){
            if(isSafe(board, row, j)){
                board[row][j] = 'Q';
                nqueens(board, ans, row+1);
                board[row][j] = '.';
            }
        }
    }
    public boolean isSafe(char[][] board, int row, int col){
        int n = board.length;
        for(int j = 0 ; j < n ; j++){
            if(board[row][j] == 'Q') return false;
        }
        for(int i = 0 ; i < n ; i++){
            if(board[i][col] == 'Q') return false;
        }
        int i = row , j = col;
        while(i >= 0 && j < n){
            if(board[i][j] == 'Q') return false;
            i--; j++;
        }
        i = row ; j = col;
        while(i < n && j < n){
            if(board[i][j] == 'Q') return false;
            i++; j++;
        }
        i = row ; j = col;
        while(i < n && j >= 0){
            if(board[i][j] == 'Q') return false;
            i++; j--;
        }
        i = row ; j = col;
        while(i >=0  && j >= 0){
            if(board[i][j] == 'Q') return false;
            i--; j--;
        }
        return true ;
    }
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i =0 ; i < n ; i++)
            Arrays.fill(board[i], '.');
        int[] ans = new int[1];
        nqueens(board, ans, 0);
        return ans[0];
    }
}
    