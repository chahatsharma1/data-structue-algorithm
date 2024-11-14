public class MaxConsecutiveOne {
    public int longestOnes(int[] nums, int k) {
        int countZero = 0;
        int max = 0;
        int start = 0;

        for (int end = 0; end < nums.length; end++){
            if (nums[end] == 0){
                countZero++;
            }

            if (countZero > k){
                if (nums[start] == 0){
                    countZero--;
                }
                start++;
            }
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}
