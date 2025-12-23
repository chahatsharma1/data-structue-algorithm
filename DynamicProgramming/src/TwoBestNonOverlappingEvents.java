import java.util.*;

public class TwoBestNonOverlappingEvents {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));

        int n = events.length;
        int[] suffixMax = new int[n];
        suffixMax[n - 1] = events[n - 1][2];

        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], events[i][2]);
        }

        int maxValue = 0;

        for (int[] event : events) {
            int currentValue = event[2];

            int nextIndex = binarySearch(events, event[1] + 1);

            if (nextIndex < n) {
                currentValue += suffixMax[nextIndex];
            }

            maxValue = Math.max(maxValue, currentValue);
        }

        return maxValue;
    }

    private int binarySearch(int[][] events, int target) {
        int left = 0, right = events.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (events[mid][0] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}