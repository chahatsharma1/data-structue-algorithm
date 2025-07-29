import java.util.*;

public class SmallestSubarraysWithMaximumBitwiseOr {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        Map<Integer, Integer> orMap = new HashMap<>();

        for (int i = n - 1; i >= 0; i--) {
            Map<Integer, Integer> newMap = new HashMap<>();
            newMap.put(nums[i], 1);

            for (Map.Entry<Integer, Integer> entry : orMap.entrySet()) {
                int newOr = entry.getKey() | nums[i];
                int newLength = entry.getValue() + 1;

                newMap.put(newOr, Math.min(newMap.getOrDefault(newOr, Integer.MAX_VALUE), newLength));
            }

            orMap = newMap;

            int maxOr = 0;
            for (int key : orMap.keySet()) {
                maxOr = Math.max(maxOr, key);
            }
            answer[i] = orMap.get(maxOr);
        }
        return answer;
    }
}
