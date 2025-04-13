public class CountGoodNumbers {
    private static final int MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long evenCount = (n + 1) / 2;
        long oddCount = n / 2;

        long evenWays = power(5, evenCount);
        long oddWays = power(4, oddCount);

        return (int)((evenWays * oddWays) % MOD);
    }

    private long power(long a, long b) {
        long result = 1;
        a = a % MOD;

        while (b > 0) {
            if ((b & 1) == 1) {
                result = (result * a) % MOD;
            }
            a = (a * a) % MOD;
            b >>= 1;
        }
        return result;
    }
}
