public class PathsInMatrixWhoseSumIsDivisibleByK {
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int MOD = 1_000_000_007;

        int[][][] dp = new int[m][n][k];

        dp[0][0][grid[0][0] % k] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];

                for (int r = 0; r < k; r++) {
                    if (i > 0) {
                        int prevR = ((r - val) % k + k) % k;
                        dp[i][j][r] = (dp[i][j][r] + dp[i-1][j][prevR]) % MOD;
                    }
                    if (j > 0) {
                        int prevR = ((r - val) % k + k) % k;
                        dp[i][j][r] = (dp[i][j][r] + dp[i][j-1][prevR]) % MOD;
                    }
                }
            }
        }
        return dp[m-1][n-1][0];
    }
}