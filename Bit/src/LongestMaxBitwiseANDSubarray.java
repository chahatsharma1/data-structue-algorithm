public class LongestMaxBitwiseANDSubarray {
    public int longestSubarray(int[] nums) {
        int max = 0;
        int longest = 0;
        int current = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        for (int num : nums) {
            if (num == max) {
                current++;
                longest = Math.max(longest, current);
            } else {
                current = 0;
            }
        }
        return longest;
    }
}
