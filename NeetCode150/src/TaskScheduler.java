import java.util.*;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) {
            if (f > 0) {
                maxHeap.add(f);
            }
        }

        int time = 0;

        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int cycle = n + 1;

            while (cycle > 0 && !maxHeap.isEmpty()) {
                int current = maxHeap.poll();
                if (current > 1) {
                    temp.add(current - 1);
                }
                time++;
                cycle--;
            }

            maxHeap.addAll(temp);

            if (!maxHeap.isEmpty()) {
                time += cycle;
            }
        }

        return time;
    }
}
