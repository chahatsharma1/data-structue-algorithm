public class MinOperationsToZero {
    public long minOperations(int[][] queries) {
        long total = 0;
        for (int[] q : queries) {
            total += operationsForQuery(q[0], q[1]);
        }
        return total;
    }

    private long operationsForQuery(int l, int r) {
        long totalSteps = prefix(r) - prefix(l - 1);
        return (totalSteps + 1) / 2;
    }

    private long prefix(long n) {
        if (n <= 0) {
            return 0;
        }

        long sum = 0;
        long power = 1;
        int step = 1;

        while (power * 4 <= n) {
            long blockSize = power * 4 - power;
            sum += (long) step * blockSize;
            power *= 4;
            step++;
        }

        sum += (long) step * (n - power + 1);

        return sum;
    }
}