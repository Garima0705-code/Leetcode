class Solution {
    public boolean isValid(char[][] board, int row, int col, char ele){
        int n = board.length;
        for(int i = 0 ; i < n; i++){
            if(board[i][col] == ele) return false;
        }
        for(int j = 0 ; j < n; j++){
            if(board[row][j] == ele) return false;
        }
        int i = (row/3)*3 ;
        int j = (col/3)*3 ;
        for(int k = i ; k <= i+2 ; k++){
            for(int l = j ; l <= j+2; l++){
                if(board[k][l] == ele) return false;
            }
        }
        return true;
    }
    public void solve(char[][] board, int row, int col, int[] arr){
        if(row == 9){
            arr[0] = 1;
            return;
        }
        if(board[row][col] != '.'){
            if(col+1 < 9) solve(board, row, col+1, arr);
            else solve(board, row+1, 0, arr);
        }else{
            for(char ch = '1'; ch <= '9' ; ch++){
                if(isValid(board,row,col,ch)){
                    board[row][col] = ch ;
                    if(col+1 < 9) solve(board, row, col+1, arr);
                    else solve(board, row+1, 0, arr);
                    if(arr[0] == 1) return;
                    board[row][col] = '.' ;
                }
            }
        }
    }
    public void solveSudoku(char[][] board) {
        int[] arr = new int[1];
        solve(board, 0, 0, arr);
    }
}