import java.util.Arrays;
import java.util.TreeMap;
import java.util.Map;

public class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);

        int n = tasks.length;
        int m = workers.length;

        int low = 0;
        int high = Math.min(n, m);
        int maxCompletedTasks = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canComplete(tasks, workers, pills, strength, mid)) {
                maxCompletedTasks = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return maxCompletedTasks;
    }

    private boolean canComplete(int[] tasks, int[] workers, int pillsLeft, int strength, int k) {
        if (k == 0) {
            return true;
        }

        TreeMap<Integer, Integer> availableStrongestWorkers = new TreeMap<>();
        int m = workers.length;
        for (int i = m - k; i < m; ++i) {
            availableStrongestWorkers.merge(workers[i], 1, Integer::sum);
        }

        for (int i = k - 1; i >= 0; --i) {

            Integer weakestSufficientWorker = availableStrongestWorkers.ceilingKey(tasks[i]);

            if (weakestSufficientWorker != null) {
                useWorker(availableStrongestWorkers, weakestSufficientWorker);
            } else {
                if (pillsLeft > 0) {
                    Integer weakestPillAidedWorker = availableStrongestWorkers.ceilingKey(tasks[i] - strength);

                    if (weakestPillAidedWorker != null) {
                        useWorker(availableStrongestWorkers, weakestPillAidedWorker);
                        --pillsLeft;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private void useWorker(Map<Integer, Integer> map, Integer strength) {
        map.merge(strength, -1, Integer::sum);
        if (map.get(strength) == 0) {
            map.remove(strength);
        }
    }
}