import java.util.ArrayList;
import java.util.List;

public class RangeProductQueries {
    private static final int MOD = 1_000_000_007;
    public int[] productQueries(int n, int[][] queries) {
        List<Integer> exponents = new ArrayList<>();
        for (int i = 0; i < 31; i++) {
            if (((n >> i) & 1) == 1) {
                exponents.add(i);
            }
        }

        int numExponents = exponents.size();
        long[] prefixSum = new long[numExponents + 1];
        for (int i = 0; i < numExponents; i++) {
            prefixSum[i + 1] = prefixSum[i] + exponents.get(i);
        }

        int[] answers = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            long totalExponent = prefixSum[right + 1] - prefixSum[left];
            answers[i] = (int) power(totalExponent);
        }
        return answers;
    }
    private long power(long exp) {
        long base = 2;
        long result = 1;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp /= 2;
        }
        return result;
    }
}