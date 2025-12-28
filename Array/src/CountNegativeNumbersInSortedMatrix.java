public class CountNegativeNumbersInSortedMatrix {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int[] ints : grid) {
            for (int anInt : ints) {
                if (anInt < 0) {
                    count++;
                }
            }
        }
        return count;
    }
}