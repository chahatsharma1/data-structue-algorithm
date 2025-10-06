import java.util.*;

public class SwimInRisingWater {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        pq.offer(new int[]{grid[0][0], 0, 0});
        
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int time = 0;
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int elevation = cur[0];
            int row = cur[1];
            int col = cur[2];
            
            time = Math.max(time, elevation);
            if (row == n - 1 && col == n - 1) {
                return time;
            }
            if (visited[row][col]) {
                continue;
            }
            visited[row][col] = true;
            
            for (int[] d : dirs) {
                int newRow = row + d[0];
                int newCol = col + d[1];
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && !visited[newRow][newCol]) {
                    pq.offer(new int[]{grid[newRow][newCol], newRow, newCol});
                }
            }
        }
        return -1;
    }
}