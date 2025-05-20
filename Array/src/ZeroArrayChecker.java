public class ZeroArrayChecker {
    public boolean canTransformToZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] freq = new int[n + 1];

        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            freq[l] += 1;
            if (r + 1 < n) {
                freq[r + 1] -= 1;
            }
        }

        int[] prefixSum = new int[n];
        prefixSum[0] = freq[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + freq[i];
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > prefixSum[i]) {
                return false;
            }
        }
        return true;
    }
}
