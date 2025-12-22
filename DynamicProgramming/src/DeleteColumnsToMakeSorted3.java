import java.util.Arrays;

public class DeleteColumnsToMakeSorted3 {
    public int minDeletionSize(String[] strs) {
        int length = strs[0].length();
        int[] dp = new int[length];
        Arrays.fill(dp, 1);

        for (int i = length-2; i >= 0; --i) {
            search: for (int j = i+1; j < length; ++j) {
            for (String row: strs) {
                if (row.charAt(i) > row.charAt(j)) {
                    continue search;
                }
            }
            dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
        }

        int kept = 0;
        for (int x: dp) {
            kept = Math.max(kept, x);
        }
        return length - kept;
    }
}