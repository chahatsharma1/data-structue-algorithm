import java.util.Arrays;

public class MaximumDifferenceBetweenEvenAndOddFrequency2 {
    public int maxDifference(String s, int k) {
        int n = s.length();
        int ans = Integer.MIN_VALUE;
        for (char a = '0'; a <= '4'; ++a) {
            for (char b = '0'; b <= '4'; ++b) {
                if (a == b) {
                    continue;
                }
                int[] best = new int[4];
                Arrays.fill(best, Integer.MAX_VALUE);
                int countA = 0, countB = 0;
                int prevA = 0, prevB = 0;
                int left = -1;

                for (int right = 0; right < n; ++right) {
                    countA += (s.charAt(right) == a) ? 1 : 0;
                    countB += (s.charAt(right) == b) ? 1 : 0;

                    while (right - left >= k && countB - prevB >= 2) {
                        int leftStatus = getStatus(prevA, prevB);
                        best[leftStatus] = Math.min(
                                best[leftStatus],
                                prevA - prevB
                        );
                        ++left;
                        prevA += (s.charAt(left) == a) ? 1 : 0;
                        prevB += (s.charAt(left) == b) ? 1 : 0;
                    }

                    int rightStatus = getStatus(countA, countB);
                    if (best[rightStatus ^ 0b10] != Integer.MAX_VALUE) {
                        ans = Math.max(ans, countA - countB - best[rightStatus ^ 0b10]
                        );
                    }
                }
            }
        }
        return ans;
    }

    private int getStatus(int countA, int countB) {
        return ((countA & 1) << 1) | (countB & 1);
    }
}