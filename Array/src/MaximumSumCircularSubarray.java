public class MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum= 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int currentMax = 0;
        int currentMin = 0;

        for (int num : nums) {
            currentMax = Math.max(num, currentMax + num);
            max = Math.max(max, currentMax);

            currentMin = Math.min(num, currentMin + num);
            min = Math.min(currentMin, min);

            totalSum += num;
        }

        if (max < 0){
            return max;
        }
        return Math.max(max, totalSum - min);
    }
}
