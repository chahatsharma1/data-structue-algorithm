public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        if (solve(board)){
            display(board);
        }
    }
    public boolean solve(char[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.'){
                    for (char num = '1'; num <= '9'; num++) {
                        if (isSafe(board, i, j, num)){
                            board[i][j] = num;
                            if (solve(board)){
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public void display(char[][] board){
        for (char[] row: board) {
            for (char num: row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    public boolean isSafe(char[][] board, int row, int col, char number){

        // check the whole row
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == number){
                return false;
            }
        }
        // check the whole col
        for (char[] nums: board) {
            if (nums[col] == number){
                return false;
            }
        }
        int sqrt = (int) Math.sqrt(board.length);
        int rowStart = row - (row % sqrt);
        int colStart = col - (col % sqrt);

        for (int r = rowStart; r < rowStart + sqrt; r++){
            for (int c = colStart; c < colStart + sqrt; c++) {
                if (board[r][c] == number){
                    return false;
                }
            }
        }
        return true;
    }
}