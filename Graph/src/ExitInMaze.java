import java.util.LinkedList;
import java.util.Queue;

public class ExitInMaze {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        int[][] directions = {{1, 0}, {0, 1}, {0, - 1}, {-1, 0}};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1], 0});

        maze[entrance[0]][entrance[1]] = '+';

        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int currentRow = current[0];
            int currentCol = current[1];
            int steps = current[2];

            for (int[] dir : directions){
                int newRow = currentRow + dir[0];
                int newCol = currentCol + dir[1];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && maze[newRow][newCol] == '.'){
                    if (newRow == 0 || newRow == m - 1 || newCol == 0 || newCol == n - 1){
                        return steps + 1;
                    }
                    maze[newRow][newCol] = '+';
                    queue.offer(new int[]{newRow, newCol, steps + 1});
                }
            }
        }
        return -1;
    }
}