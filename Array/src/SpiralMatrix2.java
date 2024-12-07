public class SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        if (n == 0){
            return ans;
        }
        int num = 1;
        int rowStart = 0;
        int colStart = 0;
        int rowEnd = n - 1;
        int colEnd = n - 1;

        while (rowStart <= rowEnd && colStart <= colEnd){

            for (int i = colStart; i <= colEnd; i++){
                ans[rowStart][i] = num++;
            }
            rowStart++;

            for (int i = rowStart; i <= rowEnd; i++){
                ans[i][colEnd] = num++;
            }
            colEnd--;

            if (rowStart <= rowEnd){
                for (int i = colEnd; i >= colStart; i--){
                    ans[rowEnd][i] = num++;
                }
            }
            rowEnd--;

            if (colStart <= colEnd){
                for (int i = rowEnd; i >= rowStart; i--){
                    ans[i][colStart] = num++;
                }
            }
            colStart++;
        }
        return ans;
    }
}
