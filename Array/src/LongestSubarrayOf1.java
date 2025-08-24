public class LongestSubarrayOf1 {
    public int longestSubarray(int[] nums) {
        int countZero = 0;
        int max = 0;
        int start = 0;

        for (int end = 0; end < nums.length; end++){
            if (nums[end] == 0){
                countZero++;
            }

            if (countZero > 1){
                if (nums[start] == 0){
                    countZero--;
                }
                start++;
            }
            max = Math.max(max, end - start);
        }
        return max;
    }
}