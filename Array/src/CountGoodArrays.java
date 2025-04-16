import java.util.HashMap;
import java.util.Map;

public class CountGoodArrays {
    public long countGood(int[] nums, int k) {
        long ans = 0;
        long totalPairs = 0;
        int left = 0;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int right = 0; right < n; right++) {
            int num = nums[right];
            int prevFreq = map.getOrDefault(num, 0);
            totalPairs+= prevFreq;
            map.put(num, prevFreq + 1);

            while (totalPairs >= k){
                ans += (n - right);
                int leftNum = nums[left];
                int countLeftNum = map.get(leftNum);
                totalPairs -= (countLeftNum - 1);
                map.put(leftNum, countLeftNum - 1);
                left++;
            }
        }
        return ans;
    }
}