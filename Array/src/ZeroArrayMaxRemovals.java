import java.util.*;

public class ZeroArrayMaxRemovals {
    public int maxRemoval(int[] nums, int[][] queries) {
        Arrays.sort(queries, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int m = queries.length;
        int n = nums.length;
        int[] end = new int[n + 1];
        int val = 0;
        int j = 0;

        for (int i = 0; i < n; ++i) {
            val -= end[i];
            while (j < m && queries[j][0] <= i) {
                pq.add(queries[j][1]);
                j++;
            }

            while (val < nums[i]) {
                if (pq.isEmpty() || pq.peek() < i) {
                    return -1;
                }
                end[pq.poll() + 1]++;
                val++;
            }
        }
        return pq.size();
    }
}