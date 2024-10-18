class MinSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++){
            sum += nums[i];

            while (sum >= target){
                minLength = Math.min(minLength, i - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }
}