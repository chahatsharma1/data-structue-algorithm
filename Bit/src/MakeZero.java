public class MakeZero {
    public int makeTheIntegerZero(int num1, int num2) {
        for (int i = 1; i <= 60; i++) {
            long target = (long) num1 - (long) i * num2;
            if (target < 0) {
                continue;
            }

            int bitCount = Long.bitCount(target);
            if (bitCount <= i && i <= target) {
                return i;
            }
        }
        return -1;
    }
}