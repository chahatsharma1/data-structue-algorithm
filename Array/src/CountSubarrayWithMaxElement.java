import java.util.Arrays;

public class CountSubarrayWithMaxElement {
    public long countSubarrays(int[] nums, int k) {
        int maxElement = Arrays.stream(nums).max().getAsInt();

        long count = 0;
        int maxCount = 0;
        long left = 0;

        for (int num : nums) {
            if (num == maxElement) {
                maxCount++;
            }

            while (maxCount == k) {

                if (nums[(int) left] == maxElement) {
                    maxCount--;
                }
                left++;
            }
            count += left;
        }

        return count;
    }
}