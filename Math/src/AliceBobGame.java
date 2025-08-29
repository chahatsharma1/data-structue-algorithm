public class AliceBobGame {
    public long countWinningPairs(int n, int m) {
        // for alice to win, the total number of flowers should be odd, and there are only 2 ways to get odd sum
        // odd + even = odd
        // even + odd = odd

        // so if we get odd number of flower from [1, n], we need even number of flower from [1, m] and vice versa

        long oddX = (n + 1) / 2;
        long evenX = n / 2;
        long oddY = (m + 1) / 2;
        long evenY = m / 2;

        return oddX * evenY + evenX * oddY;
    }
}
