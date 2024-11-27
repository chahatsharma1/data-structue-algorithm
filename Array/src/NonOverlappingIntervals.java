import java.util.Arrays;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int prevEnd = Integer.MIN_VALUE;
        int count = 0;

        for (int[] arr : intervals) {
            if (arr[0] >= prevEnd){
                prevEnd = arr[1];
            } else {
                count++;
            }
        }
        return count;
    }
}
