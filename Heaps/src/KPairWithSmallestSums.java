import java.util.*;

class KPairWithSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        if (nums1.length == 0 || nums2.length == 0 || k <= 0){
            return ans;
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int j = 0; j < nums2.length; j++){
            minHeap.add(new int[]{nums1[0] + nums2[j], 0, j});
        }

        while (k > 0 && !minHeap.isEmpty()){
            int[] smallest = minHeap.poll();
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