public class CountPartitionsWithEvenSumDifference {
    public static int countPartitions(int[] nums) {
        int n = nums.length;
        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        int count = 0;
        int leftSum = 0;

        for (int i = 0; i < n - 1; i++) {
            leftSum += nums[i];

            if (leftSum % 2 == (totalSum - leftSum) % 2) {
                count++;
            }
        }
        return count;
    }
}