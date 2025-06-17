public class ArraysWithMatchingAdjacentElements {
    private static final int MOD = 1_000_000_007;

    public int countGoodArrays(int n, int m, int k) {
        long[][] factAndInvFact = getFactAndInvFact(n);
        long[] fact = factAndInvFact[0];
        long[] invFact = factAndInvFact[1];

        long combinations = nCk(n - 1, k, fact, invFact);
        long pow = modPow(m - 1, n - k - 1);

        return (int) (m * pow % MOD * combinations % MOD);
    }

    private long modPow(long x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 1) {
            return x * modPow(x, n - 1) % MOD;
        }

        return modPow(x * x % MOD, n / 2);
    }

    private long[][] getFactAndInvFact(int n) {
        long[] fact = new long[n + 1];
        long[] invFact = new long[n + 1];
        long[] inv = new long[n + 1];

        fact[0] = invFact[0] = 1;
        inv[0] = inv[1] = 1;

        for (int i = 1; i <= n; ++i) {
            if (i >= 2) {
                inv[i] = MOD - MOD / i * inv[MOD % i] % MOD;
            }

            fact[i] = fact[i - 1] * i % MOD;
            invFact[i] = invFact[i - 1] * inv[i] % MOD;
        }

        return new long[][] { fact, invFact };
    }

    private int nCk(int n, int k, long[] fact, long[] invFact) {
        return (int) (fact[n] * invFact[k] % MOD * invFact[n - k] % MOD);
    }
}
