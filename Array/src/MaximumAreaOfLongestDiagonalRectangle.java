public class MaximumAreaOfLongestDiagonalRectangle {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int max = Integer.MIN_VALUE;
        int area = Integer.MIN_VALUE;
        for(int[] dimension : dimensions){
            int diagonal = dimension[0] * dimension[0] + dimension[1] * dimension[1];
            if(diagonal > max){
                max = diagonal;
                area = dimension[0] * dimension[1];
            } else if(diagonal == max){
                area = Math.max(area, dimension[0] * dimension[1]);
            }
        }
        return area;
    }
}