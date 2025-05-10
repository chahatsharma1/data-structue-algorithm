public class MinimumSum {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0;
        int zeroCount1 = 0;
        for (int num : nums1) {
            if (num == 0) {
                zeroCount1++;
            } else {
                sum1 += num;
            }
        }

        long sum2 = 0;
        int zeroCount2 = 0;
        for (int num : nums2) {
            if (num == 0) {
                zeroCount2++;
            } else {
                sum2 += num;
            }
        }

        long minSum1 = sum1 + zeroCount1;
        long minSum2 = sum2 + zeroCount2;

        if (minSum1 > minSum2 && zeroCount2 == 0) {
            return -1;
        }
        if (minSum2 > minSum1 && zeroCount1 == 0) {
            return -1;
        }

        return Math.max(minSum1, minSum2);
    }
}