import java.util.PriorityQueue;

public class MinimumDifferenceInSumsAfterRemovalElements {
    public long minimumDifference(int[] nums) {
        int n3 = nums.length;
        int n = n3 / 3;
        long[] part1 = new long[n + 1];
        long sum = 0;
        PriorityQueue<Integer> prefix = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            prefix.add(nums[i]);
        }
        part1[0] = sum;
        for (int i = n; i < n * 2; ++i) {
            sum += nums[i];
            prefix.add(nums[i]);
            if(!prefix.isEmpty()){
                sum -= prefix.poll();
            }
            part1[i - (n - 1)] = sum;
        }

        long part2 = 0;
        PriorityQueue<Integer> suffix = new PriorityQueue<>();
        for (int i = n * 3 - 1; i >= n * 2; --i) {
            part2 += nums[i];
            suffix.add(nums[i]);
        }
        long ans = part1[n] - part2;
        for (int i = n * 2 - 1; i >= n; --i) {
            part2 += nums[i];
            suffix.add(nums[i]);
            if(!suffix.isEmpty()) {
                part2 -= suffix.poll();
            }
            ans = Math.min(ans, part1[i - n] - part2);
        }
        return ans;
    }
}