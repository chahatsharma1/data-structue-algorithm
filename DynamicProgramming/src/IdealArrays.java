public class IdealArrays {
    private static final int MOD = 1_000_000_007;
    private long[] fact;      // Stores precomputed factorials modulo MOD
    private long[] invFact;   // Stores precomputed modular inverses of factorials modulo MOD
    private long[] combinationCache; // Caches C(k) = nCr(k + n - 1, n - 1)
    private int[] minPrimeFactor; // Stores the smallest prime factor for numbers up to maxValue

    public int idealArrays(int n, int maxValue) {
        int maxN_for_nCr = n + maxValue;
        precomputeFactorials(maxN_for_nCr);

        int primeMaxExponent = 20;
        combinationCache = new long[primeMaxExponent + 1];
        for (int k = 0; k <= primeMaxExponent; k++) {
            int n_comb = k + n - 1;
            int r_comb = n - 1;
            if (n_comb >= r_comb && r_comb >= 0) {
                combinationCache[k] = nCrMod(n_comb, r_comb);
            } else {
                combinationCache[k] = 0;
            }
        }
        if (n >= 1 && combinationCache.length > 0) {
            combinationCache[0] = 1;
        }


        sieveSPF(maxValue);

        long finalAnswer = 0;
        for (int i = 1; i <= maxValue; ++i) {
            long ways_for_i = 1;
            int currentNum = i;

            while (currentNum > 1) {
                int p = minPrimeFactor[currentNum];
                if (p == 0) {
                    if (currentNum > 1) p = currentNum;
                    else break;
                }

                int exponent = 0;
                int numBeforeDivision = currentNum;
                while (currentNum % p == 0) {
                    exponent++;
                    currentNum /= p;
                    if (currentNum == numBeforeDivision && p != 0) break;
                }

                if (p == 0) break;

                if (exponent > 0) {
                    long combFactor;
                    if(exponent < combinationCache.length) {
                        combFactor = combinationCache[exponent];
                    } else {
                        int n_comb = exponent + n - 1;
                        int r_comb = n - 1;
                        if (n_comb >= r_comb && r_comb >= 0) {
                            combFactor = nCrMod(n_comb, r_comb);
                        } else {
                            combFactor = 0;
                        }
                    }
                    ways_for_i = (ways_for_i * combFactor) % MOD;
                }
            }
            finalAnswer = (finalAnswer + ways_for_i) % MOD;
        }
        return (int) finalAnswer;
    }

    private long power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp /= 2;
        }
        return res;
    }

    private long modInverse(long n) {
        if (n <= 0) return 0;
        return power(n, MOD - 2);
    }

    private void precomputeFactorials(int maxN) {
        maxN = Math.max(maxN, 0);
        fact = new long[maxN + 1];
        invFact = new long[maxN + 1];
        fact[0] = 1;
        invFact[0] = 1;
        for (int i = 1; i <= maxN; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
            invFact[i] = modInverse(fact[i]);
        }
    }

    private long nCrMod(int n_val, int r_val) {
        if (r_val < 0 || r_val > n_val) {
            return 0;
        }
        if (n_val >= fact.length) {
            return 0;
        }

        long numerator = fact[n_val];
        long denominator = (fact[r_val] * fact[n_val - r_val]) % MOD;
        long denominatorInv = modInverse(denominator);

        return (numerator * denominatorInv) % MOD;
    }

    private void sieveSPF(int maxValue) {
        minPrimeFactor = new int[maxValue + 1];

        for (int i = 2; i <= maxValue; i++) {
            if (minPrimeFactor[i] == 0) {
                minPrimeFactor[i] = i;
                for (long j = (long)i * i; j <= maxValue; j += i) {
                    int j_int = (int)j;
                    if (minPrimeFactor[j_int] == 0) {
                        minPrimeFactor[j_int] = i;
                    }
                }
            }
        }
    }
}