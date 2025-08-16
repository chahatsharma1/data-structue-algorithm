public class SearchWord {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (search(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }

    private boolean search(char[][] board, String word, int row, int col, int index) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false;
        }

        if (index == word.length() - 1) {
            return true;
        }

        char temp = board[row][col];
        board[row][col] = '#';

        boolean found = search(board, word, row + 1, col, index + 1) ||
                        search(board, word, row - 1, col, index + 1) ||
                        search(board, word, row, col + 1, index + 1) ||
                        search(board, word, row, col - 1, index + 1);

        board[row][col] = temp;

        return found;
    }
}