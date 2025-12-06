import java.util.*;

public class CountPartitionsWithMaxMinDifferenceAtMostK {
    final long MOD = 1_000_000_007;
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;

        long[] dp = new long[n + 1];
        long[] prefix = new long[n + 1];
        dp[0] = 1;
        prefix[0] = 1;

        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();

        int left = 0;

        for (int i = 0; i < n; i++) {

            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] < nums[i]) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(i);

            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] > nums[i]) {
                minDeque.pollLast();
            }
            minDeque.addLast(i);

            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > k) {
                if (maxDeque.peekFirst() == left) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() == left) {
                    minDeque.pollFirst();
                }
                left++;
            }

            long total = prefix[i];
            long subtract = (left == 0 ? 0 : prefix[left - 1]);

            dp[i + 1] = (total - subtract + MOD) % MOD;

            prefix[i + 1] = (prefix[i] + dp[i + 1]) % MOD;
        }
        return (int) dp[n];
    }
}