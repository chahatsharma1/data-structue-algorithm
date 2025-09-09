import java.util.*;

public class SmallestIntervalForQueries {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = queries.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        Integer[] queryIndices = new Integer[n];
        for (int i = 0; i < n; i++) {
            queryIndices[i] = i;
        }
        Arrays.sort(queryIndices, Comparator.comparingInt(a -> queries[a]));

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> (a[1] - a[0])));
        
        int i = 0;
        for (int idx : queryIndices) {
            int q = queries[idx];

            while (i < intervals.length && intervals[i][0] <= q) {
                minHeap.offer(intervals[i]);
                i++;
            }

            while (!minHeap.isEmpty() && minHeap.peek()[1] < q) {
                minHeap.poll();
            }

            if (!minHeap.isEmpty()) {
                int[] interval = minHeap.peek();
                result[idx] = interval[1] - interval[0] + 1;
            }
        }
        return result;
    }
}
