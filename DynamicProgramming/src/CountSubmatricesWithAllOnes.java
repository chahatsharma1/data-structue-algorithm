import java.util.Stack;

public class CountSubmatricesWithAllOnes {
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] height = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    height[i][j] = (i == 0 ? 0 : height[i - 1][j]) + 1;
                }
            }
        }
        
        int result = 0;
        for (int i = 0; i < m; i++) {
            result += countSubmatRow(height[i]);
        }
        return result;
    }
    
    private int countSubmatRow(int[] row) {
        int n = row.length;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        int[] sum = new int[n];
        
        for (int j = 0; j < n; j++) {
            while (!stack.isEmpty() && row[stack.peek()] >= row[j]) {
                stack.pop();
            }
            
            if (!stack.isEmpty()) {
                int prev = stack.peek();
                sum[j] = sum[prev] + row[j] * (j - prev);
            } else {
                sum[j] = row[j] * (j + 1);
            }
            
            res += sum[j];
            stack.push(j);
        }
        return res;
    }
}
