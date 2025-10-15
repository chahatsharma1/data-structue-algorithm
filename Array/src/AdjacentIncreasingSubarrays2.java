import java.util.List;

public class AdjacentIncreasingSubarrays2 {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int count = 1;
        int preCount = 0;
        int ans = 0;

        for (int i = 1; i < n; ++i) {
            if (nums.get(i) > nums.get(i - 1)) {
                ++count;
            } else {
                preCount = count;
                count = 1;
            }
            ans = Math.max(ans, Math.min(preCount, count));
            ans = Math.max(ans, count / 2);
        }
        return ans;
    }
}