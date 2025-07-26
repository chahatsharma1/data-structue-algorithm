import java.util.Arrays;

public class MaximizeSubarraysAfterRemovingOneConflictingPair {
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        int[] min1 = new int[n + 1];
        int[] min2 = new int[n + 1];
        Arrays.fill(min1, Integer.MAX_VALUE);
        Arrays.fill(min2, Integer.MAX_VALUE);
        for (int[] pair : conflictingPairs) {
            int a = Math.min(pair[0], pair[1]);
            int b = Math.max(pair[0], pair[1]);
            if (min1[a] > b) {
                min2[a] = min1[a];
                min1[a] = b;
            } else if (min2[a] > b) {
                min2[a] = b;
            }
        }
        long res = 0;
        int b1 = n;
        int b2 = Integer.MAX_VALUE;
        long[] delCount = new long[n + 1];
        for (int i = n; i >= 1; i--) {
            if (min1[b1] > min1[i]) {
                b2 = Math.min(b2, min1[b1]);
                b1 = i;
            } else {
                b2 = Math.min(b2, min1[i]);
            }
            int min = Math.min(min1[b1], n + 1);
            res += min - i;
            delCount[b1] += Math.min(Math.min(b2, min2[b1]), n + 1) - min;
        }
        long max = 0;
        for (long val : delCount) {
            max = Math.max(max, val);
        }
        return res + max;
    }
}