import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class MinPathGrid {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{0, 0, 0});

        int[][] cost = new int[m][n];
        for (int[] row : cost){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        cost[0][0] = 0;

        while (!deque.isEmpty()){
            int[] current = deque.pollFirst();
            int currentRow = current[0];
            int currentCol = current[1];
            int currentCost = current[2];

            if (currentRow == m - 1 && currentCol == n - 1){
                return currentCost;
            }

            for (int i = 0; i < directions.length; i++){
                int newRow = currentRow + directions[i][0];
                int newCol = currentCol + directions[i][1];
                int newCost = currentCost + (i + 1 == grid[currentRow][currentCol] ? 0 : 1);

                if (newRow >= 0 && newCol >= 0 && newRow < m && newCol < n && newCost < cost[newRow][newCol]){
                    cost[newRow][newCol] = newCost;
                    if (i + 1 == grid[currentRow][currentCol]){
                        deque.addFirst(new int[]{newRow, newCol, newCost});
                    } else {
                        deque.addLast(new int[]{newRow, newCol, newCost});
                    }
                }
            }
        }
        return -1;
    }
}