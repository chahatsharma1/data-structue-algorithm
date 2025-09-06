import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

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