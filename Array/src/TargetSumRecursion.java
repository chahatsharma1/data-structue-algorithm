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
}
