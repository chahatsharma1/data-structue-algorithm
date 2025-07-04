public class KCharacterInString2 {
    public char kthCharacter(long k, int[] operations) {
        int increases = 0;
        int operationsCount = 0;
        long length = 1;

        while (length < k) {
            length *= 2;
            operationsCount++;
        }

        for (int i = operationsCount - 1; i >= 0; --i) {
            long halfSize = 1L << i;
            if (k > halfSize) {
                k -= halfSize;
                increases += operations[i];
            }
        }
        return (char) ('a' + increases % 26);
    }
}