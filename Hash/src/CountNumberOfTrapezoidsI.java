import java.util.*;

public class CountNumberOfTrapezoidsI {
    final long MOD = 1_000_000_007;
    public int countTrapezoids(int[][] points) {
        Map<Integer, Long> countByY = new HashMap<>();

        for (int[] p : points) {
            int y = p[1];
            countByY.put(y, countByY.getOrDefault(y, 0L) + 1);
        }

        List<Long> segments = new ArrayList<>();
        for (long c : countByY.values()) {
            if (c >= 2) {
                long seg = c * (c - 1) / 2;
                segments.add(seg % MOD);
            }
        }

        if (segments.size() < 2) {
            return 0;
        }

        long sum = 0;
        for (long v : segments) {
            sum = (sum + v) % MOD;
        }

        long result = 0;
        for (long v : segments) {
            sum = (sum - v + MOD) % MOD;
            result = (result + v * sum) % MOD;
        }
        return (int) result;
    }
}
