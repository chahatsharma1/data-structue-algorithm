import java.util.Arrays;

public class FreqOfMaxFrequentElement {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        long sum = 0;
        int maxFreq = 0;

        for (right = 0; right < nums.length; right++){
            sum += nums[right];

            while ((long) nums[right] * (right- left + 1) - sum > k){
                sum -= nums[left];
                left++;
            }
            maxFreq = Math.max(maxFreq, (right- left + 1));
        }
        return maxFreq;
    }
}
