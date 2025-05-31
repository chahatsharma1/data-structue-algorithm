import java.util.LinkedList;
import java.util.Queue;

class SnakeAndLadder {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int target = n * n;
        int[] arr = new int[target + 1];

        int index = 1;
        boolean leftToRight = true;
        for (int row = n - 1; row >= 0; row--){
            if (leftToRight){
                for (int col = 0; col < n; col++){
                    arr[index++] = board[row][col];
                }
            } else {
                for (int col = n - 1; col >= 0; col--) {
                    arr[index++] = board[row][col];
                }
            }
            leftToRight = !leftToRight;
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[target + 1];
        queue.offer(1);
        visited[1] = true;
        int moves = 0;

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int current = queue.poll();
                if (current == target){
                    return moves;
                }
                for (int dice = 1; dice <= 6 ; dice++) {
                    int next = current + dice;
                    if (next > target){
                        break;
                    }

                    if (arr[next] != - 1){
                        next = arr[next];
                    }

                    if (!visited[next]){
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}