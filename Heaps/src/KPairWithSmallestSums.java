import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class KPairWithSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        if (nums1.length == 0 || nums2.length == 0 || k <= 0){
            return ans;
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int j = 0; j < nums2.length; j++){
            minHeap.add(new int[]{nums1[0] + nums2[j], 0, j});
        }

        while (k > 0 && !minHeap.isEmpty()){
            int[] smallest = minHeap.poll();
            int sum = smallest[0];
            int i = smallest[1];
            int j = smallest[2];

            ans.add(Arrays.asList(nums1[i], nums2[j]));

            if (i + 1 < nums1.length){
                minHeap.offer(new int[]{nums1[i + 1] + nums2[j], i + 1, j});
            }
            k--;
        }
        return ans;
    }
}