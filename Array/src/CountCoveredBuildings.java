import java.util.*;

public class CountCoveredBuildings {
    public int countCovered(int[][] buildings) {
        Map<Integer, int[]> rowMap = new HashMap<>();
        Map<Integer, int[]> colMap = new HashMap<>();

        for (int[] b : buildings) {
            int x = b[0];
            int y = b[1];

            rowMap.putIfAbsent(x, new int[]{y, y}); 
            colMap.putIfAbsent(y, new int[]{x, x});

            rowMap.get(x)[0] = Math.min(rowMap.get(x)[0], y);
            rowMap.get(x)[1] = Math.max(rowMap.get(x)[1], y);

            colMap.get(y)[0] = Math.min(colMap.get(y)[0], x);
            colMap.get(y)[1] = Math.max(colMap.get(y)[1], x);
        }

        int covered = 0;

        for (int[] b : buildings) {
            int x = b[0];
            int y = b[1];

            int[] row = rowMap.get(x);
            int[] col = colMap.get(y);

            boolean hasLeft = y > row[0];
            boolean hasRight = y < row[1];
            boolean hasAbove = x > col[0];
            boolean hasBelow = x < col[1];

            if (hasLeft && hasRight && hasAbove && hasBelow) {
                covered++;
            }
        }
        return covered;
    }
}
