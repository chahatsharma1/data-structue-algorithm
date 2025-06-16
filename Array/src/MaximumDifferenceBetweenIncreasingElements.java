public class MaximumDifferenceBetweenIncreasingElements {
    public int maximumDifference(int[] nums) {
        int i = 0;
        int max = -1;
        for (int j = 0; j < nums.length; j++){
            if(nums[j] > nums[i]){
                max = Math.max(max, nums[j] - nums[i]);
            } else {
                i = j;
            }
        }
        return max;
    }
}