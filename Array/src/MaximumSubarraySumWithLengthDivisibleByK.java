public class MaximumSubarraySumWithLengthDivisibleByK {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;

        long[] prefix = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }

        long[] minPrefix = new long[k];
        boolean[] seen = new boolean[k];

        long maxSum = Long.MIN_VALUE;

        for (int i = 0; i <= n; i++) {
            int mod = i % k;

            if (seen[mod]) {
                long candidate = prefix[i] - minPrefix[mod];
                maxSum = Math.max(maxSum, candidate);
            }

            if (!seen[mod] || prefix[i] < minPrefix[mod]) {
                minPrefix[mod] = prefix[i];
                seen[mod] = true;
            }
        }
        return maxSum;
    }
}