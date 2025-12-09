import java.util.*;

public class CountSpecialTriplets {
    public int countTriplets(int[] nums) {
        final long MOD = 1_000_000_007;

        Map<Integer, Long> right = new HashMap<>();
        for (int x : nums) {
            right.put(x, right.getOrDefault(x, 0L) + 1);
        }

        Map<Integer, Long> left = new HashMap<>();
        long result = 0;

        for (int val : nums) {
            long countRight = right.get(val) - 1;
            right.put(val, countRight);

            long iCount = left.getOrDefault(val * 2, 0L);
            long kCount = right.getOrDefault(val * 2, 0L);

            result = (result + (iCount * kCount) % MOD) % MOD;

            left.put(val, left.getOrDefault(val, 0L) + 1);
        }

        return (int) result;
    }
}