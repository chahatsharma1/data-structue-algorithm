import java.util.Arrays;

public class MaxDistinctElements {
    public static int maxDistinct(int[] nums, int k) {
        Arrays.sort(nums);
        long last = Long.MIN_VALUE;
        int count = 0;

        for (int num : nums) {
            long minPossible = (long) num - k;
            long maxPossible = (long) num + k;

            long candidate = Math.max(minPossible, last + 1);

            if (candidate <= maxPossible) {
                count++;
                last = candidate;
            }
        }
        return count;
    }
}