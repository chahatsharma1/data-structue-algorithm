public class MaximumRunningTimeOfNComputers {
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        for (int b : batteries) {
            sum += b;
        }

        long left = 0;
        long right = sum / n;

        while (left < right) {
            long mid = (left + right + 1) / 2;

            if (canRun(mid, n, batteries)){
                left = mid;
            }
            else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean canRun(long T, int n, int[] batteries) {
        long usable = 0;

        for (int b : batteries) {
            usable += Math.min(b, T);
            if (usable >= T * n) {
                return true;
            }  
        }
        return false;
    }
}