import java.util.Arrays;

public class PowerfulIntegers {
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - '0' > limit) {
                return 0;
            }
        }
        long countFinish = countPowerfulUpTo(String.valueOf(finish), s, limit);
        long countStartMinus1 = countPowerfulUpTo(String.valueOf(start - 1), s, limit);
        return countFinish - countStartMinus1;
    }

    private long dfs(int index, boolean tight, boolean isLeading, String num, long[][][] dp, String s, int limit) {
        if (index == num.length()) {
            return isLeading ? 0 : 1;
        }

        if (dp[index][tight ? 1 : 0][isLeading ? 1 : 0] != -1) {
            return dp[index][tight ? 1 : 0][isLeading ? 1 : 0];
        }

        long count = 0;
        int upperBound = tight ? (num.charAt(index) - '0') : 9;

        for (int digit = 0; digit <= upperBound; digit++) {
            if (digit > limit) {
                continue;
            }
            if (!isLeading && index >= num.length() - s.length()) {
                int suffixIndex = index - (num.length() - s.length());
                int requiredSuffixDigit = s.charAt(suffixIndex) - '0';

                if (digit != requiredSuffixDigit) {
                    continue;
                }
            }

            boolean nextTight = tight && (digit == (num.charAt(index) - '0'));
            boolean nextIsLeading = isLeading && (digit == 0);
            count += dfs(index + 1, nextTight, nextIsLeading, num, dp, s, limit);
        }

        dp[index][tight ? 1 : 0][isLeading ? 1 : 0] = count;
        return count;
    }

    private long countPowerfulUpTo(String num, String s, int limit) {
        if (num.length() < s.length()) {
            return 0;
        }
        long[][][] dp = new long[num.length()][2][2];
        for (long[][] layer1 : dp) {
            for (long[] layer2 : layer1) {
                Arrays.fill(layer2, -1);
            }
        }
        return dfs(0, true, true, num, dp, s, limit);
    }
}
