public class TargetSumRecursion {
    public static int findTargetSumWays(int[] nums, int target) {
        return calculateWays(nums, target, 0, 0);
    }

    private static int calculateWays(int[] nums, int target, int index, int currentSum) {
        if (index == nums.length) {
            return currentSum == target ? 1 : 0;
        }

        int add = calculateWays(nums, target, index + 1, currentSum + nums[index]);
        int subtract = calculateWays(nums, target, index + 1, currentSum - nums[index]);
        return add + subtract;
    }

    public static class ThirdMaximumNumber {
        public static int thirdMax(int[] nums) {
            Long max1 = null;
            Long max2 = null;
            Long max3 = null;

            for (int num : nums) {
                long n = (long) num;

                if ((max1 != null && n == max1) || (max2 != null && n == max2) || (max3 != null && n == max3)) {
                    continue;
                }

                if (max1 == null || n > max1) {
                    max3 = max2;
                    max2 = max1;
                    max1 = n;
                } else if (max2 == null || n > max2) {
                    max3 = max2;
                    max2 = n;
                } else if (max3 == null || n > max3) {
                    max3 = n;
                }
            }
            return max3 != null ? max3.intValue() : max1.intValue();
        }
    }
}
