import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1){
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));

        List<int[]> list = new ArrayList<>();
        int[] current = intervals[0];
        list.add(current);

        for (int[] interval: intervals) {
            int currentEnd = current[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (currentEnd >= nextStart) {
                current[1] = Math.max(currentEnd, nextEnd);
            } else {
                current = interval;
                list.add(current);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}