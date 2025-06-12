public class MaxDiffInCircularArray {
    public int maxAdjacentDistance(int[] nums){
        int n = nums.length;
        int max = 0;

        for(int i = 0; i < n; i++){
            int diff = Math.abs(nums[i % n] - nums[(i + 1) % n]);
            max = Math.max(diff, max);
        }

        return max;
    }
}