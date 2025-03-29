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

    public static class CheckSortedRotated {
        public boolean check(int[] nums) {
            int countDrop = 0;
            int n = nums.length;

            for (int i = 0; i < n; i++) {
                // Check for a drop in sorted order
                if (nums[i] > nums[(i + 1) % n]) {
                    countDrop++;
                }

                // If we find more than one drop, it's not a rotated sorted array
                if (countDrop > 1) {
                    return false;
                }
            }
            return true;
        }

        public static void main(String[] args) {
            CheckSortedRotated solution = new CheckSortedRotated();
            int[] nums1 = {3, 4, 5, 1, 2};  // Rotated version of [1, 2, 3, 4, 5]
            int[] nums2 = {2, 1, 3, 4};  // Not a rotated sorted array
            int[] nums3 = {1, 2, 3, 4, 5};  // Already sorted (valid rotation with 0 shifts)

            System.out.println(solution.check(nums1)); // true
            System.out.println(solution.check(nums2)); // false
            System.out.println(solution.check(nums3)); // true
        }
    }
}
