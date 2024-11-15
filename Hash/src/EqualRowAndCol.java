import java.util.Arrays;
import java.util.HashMap;

public class EqualRowAndCol {
    public int equalPairs(int[][] grid) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int[] row : grid){
            String rowKey = Arrays.toString(row);
            map.put(rowKey, map.getOrDefault(rowKey, 0) + 1);
        }
        int count = 0;

        for (int col = 0; col < grid.length; col++) {
            int[] colArray = new int[grid.length];
            for (int row = 0; row < grid.length; row++){
                colArray[row] = grid[row][col];
            }

            String colKey = Arrays.toString(colArray);
            count += map.getOrDefault(colKey, 0);
        }
        return count;
    }
}
