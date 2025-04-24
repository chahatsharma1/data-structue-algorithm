import java.util.*;

public class CompleteSubarrays {
    public int countCompleteSubarrays(int[] nums) {
        int totalDistinct = getTotalDistinct(nums);
        int count = 0;
        int left = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int right = 0; right < nums.length; right++) {
            freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);

            while (freqMap.size() == totalDistinct) {
                count += nums.length - right;
                freqMap.put(nums[left], freqMap.get(nums[left]) - 1);
                if (freqMap.get(nums[left]) == 0) {
                    freqMap.remove(nums[left]);
                }
                left++;
            }
        }
        return count;
    }

    private int getTotalDistinct(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size();
    }
}
