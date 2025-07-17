import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequence {
    public int longestArithmeticSeqLength(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }

        Map<Integer, Integer>[] dp = new HashMap[n];
        int maxLength = 2;

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
            
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                int lengthAtJ = dp[j].getOrDefault(diff, 1);
                int newLength = lengthAtJ + 1;

                dp[i].put(diff, newLength);

                maxLength = Math.max(maxLength, newLength);
            }
        }
        return maxLength;
    }
}