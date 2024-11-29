import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxSubseqScore {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] pairs = new int[n][2];

        for (int i = 0; i < n; i++){
            pairs[i][0] = nums1[i];
            pairs[i][1] = nums2[i];
        }

        Arrays.sort(pairs, (a, b) -> b[1] - a[1]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long max = 0;
        long currentSum = 0;

        for (int i = 0; i < n; i++){
            minHeap.offer(pairs[i][0]);
            currentSum += pairs[i][0];

            if (minHeap.size() > k){
                currentSum -= minHeap.poll();
            }

            if (minHeap.size() == k){
                max = Math.max(max, currentSum * pairs[i][1]);
            }
        }
        return max;
    }
}
