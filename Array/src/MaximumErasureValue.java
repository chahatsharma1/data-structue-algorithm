import java.util.HashSet;

public class MaximumErasureValue {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max = 0;
        int n = nums.length;
        int i = 0;
        int j = 0;
        int currentSum = 0;

        while(j < n){
            if (!set.contains(nums[j])){
                set.add(nums[j]);
                currentSum += nums[j];
                max = Math.max(max, currentSum);
                j++;
            } else {
                set.remove(nums[i]);
                currentSum -= nums[i];
                i++;
            }
        }
        return max;
    }
}