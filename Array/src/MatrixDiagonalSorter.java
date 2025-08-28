import java.util.*;

public class MatrixDiagonalSorter {
    public int[][] diagonalSort(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return grid;
        }
        int n = grid.length;

        for (int i = 0; i < n; i++) {
            List<Integer> diagonal = new ArrayList<>();
            for (int r = i, c = 0; r < n && c < n; r++, c++) {
                diagonal.add(grid[r][c]);
            }

            diagonal.sort(Collections.reverseOrder());

            int index = 0;
            for (int r = i, c = 0; r < n && c < n; r++, c++) {
                grid[r][c] = diagonal.get(index++);
            }
        }

        for (int j = 1; j < n; j++) {
            List<Integer> diagonal = new ArrayList<>();
            for (int r = 0, c = j; r < n && c < n; r++, c++) {
                diagonal.add(grid[r][c]);
            }

            Collections.sort(diagonal);

            int index = 0;
            for (int r = 0, c = j; r < n && c < n; r++, c++) {
                grid[r][c] = diagonal.get(index++);
            }
        }
        return grid;
    }
}