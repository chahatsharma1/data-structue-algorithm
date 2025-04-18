public class NthRootNumber {
    public static int nthRoot(int n, int m) {
        if (n == 1) {
            return m;
        }

        long low = 1, high = m;
        long mid;
        long ans = -1;
        while (low <= high) {
            mid = (low + high) / 2;
            long x = mid;
            for (int i = 1; i < n; i++) {
                x *= mid;
                if (x > m) {
                    break;
                }
            }
            if (x == m) {
                ans = mid;
                break;
            } else if (x > m)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return (int)ans;
    }
}
