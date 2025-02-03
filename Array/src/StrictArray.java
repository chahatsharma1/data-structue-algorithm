public class StrictArray {
    public int longestMonotonicSubarray(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        int longest = 1;
        int incLen = 1;
        int decLen = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                incLen++;
                decLen = 1;
            } else if (nums[i] < nums[i - 1]) {
                decLen++;
                incLen = 1;
            } else {
                incLen = decLen = 1;
            }
            longest = Math.max(longest, Math.max(incLen, decLen));
        }

        return longest;
    }
}
