import java.util.*;

public class XSumSlidingWindow {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] answer = new int[n - k + 1];

        Map<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < k; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        answer[0] = computeXSum(freq, x);

        for (int i = k; i < n; i++) {
            int out = nums[i - k];
            int in = nums[i];

            freq.put(out, freq.get(out) - 1);
            if (freq.get(out) == 0) {
                freq.remove(out);
            }
            freq.put(in, freq.getOrDefault(in, 0) + 1);

            answer[i - k + 1] = computeXSum(freq, x);
        }

        return answer;
    }

    private int computeXSum(Map<Integer, Integer> freq, int x) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (b[1] != a[1]) {
                return b[1] - a[1];
            }
            return b[0] - a[0];
        });

        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            pq.offer(new int[]{e.getKey(), e.getValue()});
        }

        int sum = 0;
        int count = 0;
        while (!pq.isEmpty() && count < x) {
            int[] curr = pq.poll();
            sum += curr[0] * curr[1];
            count++;
        }

        return sum;
    }
}