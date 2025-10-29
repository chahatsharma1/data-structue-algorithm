public class OnlySetBits {
    public int smallestAllSetBits(long n) {
        long x = 1;

        while (x < n) {
            x = (x << 1) | 1;
        }
        return (int) x;
    }
}