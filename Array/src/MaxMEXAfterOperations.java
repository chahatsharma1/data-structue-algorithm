public class MaxMEXAfterOperations {
    public static int findMaximumMEX(int[] nums, int value) {
        int[] count = new int[value];

        for (int num : nums) {
            int rem = ((num % value) + value) % value;
            count[rem]++;
        }

        int mex = 0;
        while (true) {
            int rem = mex % value;
            if (count[rem] > 0) {
                count[rem]--;
                mex++;
            } else {
                break;
            }
        }
        return mex;
    }
}