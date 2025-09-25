import java.util.Arrays;
import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return find(0, 0, n, triangle, dp);
    }

    public static int find(int row, int col, int n, List<List<Integer>> triangle, int[][] dp){
        if (row == n - 1){
            return triangle.get(row).get(col);
        }
        if (dp[row][col] != -1){
            return dp[row][col];
        }
        int down = triangle.get(row).get(col) + find(row + 1, col, n, triangle, dp);
        int diagonal = triangle.get(row).get(col) + find(row + 1, col + 1, n, triangle, dp);
        return dp[row][col] = Math.min(down, diagonal);
    }
}