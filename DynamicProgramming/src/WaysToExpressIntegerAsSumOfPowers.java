public class WaysToExpressIntegerAsSumOfPowers {
    public int numberOfWays(int n, int x) {
        int MOD = 1_000_000_007;

        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (int num = 1; ; num++) {
            long power = 1;
            boolean overflow = false;
            for (int i = 0; i < x; i++) {
                power *= num;
                if (power > n) {
                    overflow = true;
                    break;
                }
            }

            if (overflow) {
                break;
            }

            for (int i = n; i >= (int) power; i--) {
                dp[i] = (dp[i] + dp[i - (int) power]) % MOD;
            }
        }

        return (int) dp[n];
    }
}