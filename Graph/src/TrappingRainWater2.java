import java.util.PriorityQueue;

public class TrappingRainWater2 {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null){
            return 0;
        }

        int m = heightMap.length;
        int n = heightMap[0].length;

        PriorityQueue<Cell> priorityQueue = new PriorityQueue<>((a, b) -> a.height - b.height);
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (i == 0 || j == 0 || i == m -1 || j == n -1){
                    priorityQueue.offer(new Cell(i, j, heightMap[i][j]));
                    visited[i][j] = true;
                }
            }
        }
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int ans = 0;

        while (!priorityQueue.isEmpty()){
            Cell cell = priorityQueue.poll();

            for (int[] dir : directions){
                int newRow = cell.row + dir[0];
                int newCol = cell.col + dir[1];

                if (newRow < 0 || newCol < 0 || newRow >= m || newCol >= n || visited[newRow][newCol]){
                    continue;
                }

                ans += Math.max(0, (cell.height - heightMap[newRow][newCol]));
                priorityQueue.offer(new Cell(newRow, newCol, Math.max(cell.height, heightMap[newRow][newCol])));
                visited[newRow][newCol] = true;
            }
        }
        return ans;
    }   
}