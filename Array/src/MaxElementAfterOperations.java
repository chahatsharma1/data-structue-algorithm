public class MaxElementAfterOperations {
    public static int maximizeElement(int[] nums, int k, int numOperations) {
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max + k;
    }
}