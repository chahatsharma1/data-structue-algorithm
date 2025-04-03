public class MaxTripletValue2 {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return 0;
        }

        long maxVal = 0;
        long maxI = nums[0];
        long maxIJ = Integer.MIN_VALUE;

        for (int j = 1; j < n - 1; j++) {
            maxIJ = Math.max(maxIJ, maxI - nums[j]);
            maxVal = Math.max(maxVal, maxIJ * nums[j + 1]);
            maxI = Math.max(maxI, nums[j]);
        }
        return maxVal;
    }
}
