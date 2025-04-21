public class HiddenSequence {
    public int numberOfValidSequences(int[] differences, int lower, int upper) {
        long prefixSum = 0;
        long minSum = 0;
        long maxSum = 0;

        for (int diff : differences) {
            prefixSum += diff;
            minSum = Math.min(minSum, prefixSum);
            maxSum = Math.max(maxSum, prefixSum);
        }

        long startMin = lower - minSum;
        long startMax = upper - maxSum;

        if (startMin > startMax) return 0;
        return (int)(startMax - startMin + 1);
    }
}
