public class MaximumLengthOfValidSubsequence2 {
    public int maximumLength(int[] nums, int k) {
        int[][] dp = new int[k][k];
        int maxLength = 0;

        for (int num : nums) {
            int currentRem = num % k;
            for (int targetMod = 0; targetMod < k; targetMod++) {
                int prevRem = (targetMod - currentRem + k) % k;
                dp[targetMod][currentRem] = 1 + dp[targetMod][prevRem];
                if (dp[targetMod][currentRem] > maxLength) {
                    maxLength = dp[targetMod][currentRem];
                }
            }
        }
        return maxLength;
    }
}