public class GridGame {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;

        long[] prefixTop = new long[n];
        long[] prefixBottom = new long[n];
        prefixTop[0] = grid[0][0];
        prefixBottom[0] = grid[1][0];

        for (int j = 1; j < n; j++) {
            prefixTop[j] = prefixTop[j - 1] + grid[0][j];
            prefixBottom[j] = prefixBottom[j - 1] + grid[1][j];
        }

        long ans = Long.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            long pointsTop = j == n - 1 ? 0 : prefixTop[n - 1] - prefixTop[j];
            long pointsBottom = j == 0 ? 0 : prefixBottom[j - 1];

            long pointsForRobot2 = Math.max(pointsTop, pointsBottom);
            ans = Math.min(ans, pointsForRobot2);
        }
        return ans;
    }
}
