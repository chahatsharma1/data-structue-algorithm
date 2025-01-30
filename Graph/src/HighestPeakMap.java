import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class HighestPeakMap {
    public int[][] highestPeak(int[][] isWater){
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int m = isWater.length;
        int n = isWater[0].length;

        int[][] height = new int[m][n];
        for (int[] row : height){
            Arrays.fill(row, -1);
        }

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1){
                    height[i][j] = 0;
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            for (int[] dir : directions){
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < m && newCol < n && newCol >= 0 && height[newRow][newCol] == -1){
                    height[newRow][newCol] = height[row][col] + 1;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
        return height;
    }
}
