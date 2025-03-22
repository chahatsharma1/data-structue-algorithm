public class GameOfLife {
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                int liveNeighbors = count(board, i, j);

                if (board[i][j] == 1){
                    if (liveNeighbors < 2 || liveNeighbors > 3){
                        board[i][j] = 2;
                    }
                } else {
                    if (liveNeighbors == 3){
                        board[i][j] = 3;
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 2){
                    board[i][j] = 0;
                } else if (board[i][j] == 3){
                 board[i][j] = 1;
                }
            }
        }
    }

    private int count(int[][] board, int row, int col){
        int[] directions = {-1, 0, 1};
        int liveCount = 0;

        for (int dr : directions){
            for (int dc : directions){
                if (dr == 0 && dc == 0){
                    continue;
                }
                int newRow = dr + row;
                int newCol = dc + col;

                if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length
                        && (board[newRow][newCol] == 1 || board[newRow][newCol] == 2)){
                    liveCount++;
                }
            }
        }
        return liveCount;
    }
}
