import java.util.*;

public class MaxSpellDamage {
    public static long maxTotalDamage(int[] power) {
        if (power == null || power.length == 0) {
            return 0;
        }

        Map<Integer, Long> damageMap = new HashMap<>();
        for (int p : power) {
            damageMap.put(p, damageMap.getOrDefault(p, 0L) + p);
        }

        List<Integer> keys = new ArrayList<>(damageMap.keySet());
        Collections.sort(keys);

        int n = keys.size();
        long[] dp = new long[n];
        dp[0] = damageMap.get(keys.getFirst());

        for (int i = 1; i < n; i++) {
            int currVal = keys.get(i);
            long currDamage = damageMap.get(currVal);
            long exclude = dp[i - 1];
            long include = currDamage;
            int j = i - 1;

            while (j >= 0 && currVal - keys.get(j) <= 2) {
                j--;
            }

            if (j >= 0) {
                include += dp[j];
            }
            dp[i] = Math.max(exclude, include);
        }
        return dp[n - 1];
    }
}