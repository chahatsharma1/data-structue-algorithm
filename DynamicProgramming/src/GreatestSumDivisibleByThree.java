public class GreatestSumDivisibleByThree {
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[3];
        dp[1] = dp[2] = Integer.MIN_VALUE / 2;

        for (int num : nums) {
            int[] temp = dp.clone();

            for (int r = 0; r < 3; r++) {
                int newSum = temp[r] + num;
                int newR = ((newSum % 3) + 3) % 3;
                dp[newR] = Math.max(dp[newR], newSum);
            }
        }

        return dp[0];
    }
}