class Solution {
    public void nqueens(char[][] board, List<List<String>> ans, int row){
        int n = board.length;
        if(n == row){
            List<String> a = new ArrayList<>();
            for(int i = 0 ; i < n ; i++){
                String s = new String(board[i]);
                a.add(s);
            }
            ans.add(a);
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
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i =0 ; i < n ; i++)
            Arrays.fill(board[i], '.');
        nqueens(board, ans, 0);
        return ans;
    }
}