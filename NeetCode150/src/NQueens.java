import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        solveNQueensUtil(board, 0, solutions);
        return solutions;
    }

    private void solveNQueensUtil(boolean[][] board, int row, List<List<String>> solutions) {
        if (row == board.length) {
            solutions.add(generateSolution(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                solveNQueensUtil(board, row + 1, solutions);
                board[row][col] = false;
            }
        }
    }

    private List<String> generateSolution(boolean[][] board) {
        List<String> solution = new ArrayList<>();
        for (boolean[] booleans : board) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < board.length; j++) {
                row.append(booleans[j] ? 'Q' : '.');
            }
            solution.add(row.toString());
        }
        return solution;
    }

    private boolean isSafe(boolean[][] board, int row, int col) {
        // vertical up
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }

        // left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) {
                return false;
            }
        }

        // right diagonal
        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j]) {
                return false;
            }
        }

        return true;
    }
}