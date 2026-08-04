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
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                char ch = board[i][j];
                board[i][j] = '.';
                if(ch != '.' && isValid(board, i, j, ch) == false) return false;
                board[i][j] = ch;
            }
        }
        return true;
    }
}