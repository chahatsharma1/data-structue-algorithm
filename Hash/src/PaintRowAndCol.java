import java.util.HashMap;
import java.util.Map;

public class PaintRowAndCol {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Map<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.put(mat[i][j], new int[]{i, j});
            }
        }

        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        for (int i = 0; i < arr.length; i++){
            int num = arr[i];
            int[] current = map.get(num);
            int row = current[0];
            int col = current[1];

            rowCount[row]++;
            colCount[col]++;

            if (rowCount[row] == n || colCount[col] == m ){
                return i;
            }
        }
        return -1;
    }
}
