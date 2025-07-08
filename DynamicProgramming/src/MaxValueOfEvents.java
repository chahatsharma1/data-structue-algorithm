import java.util.Arrays;

public class MaxValueOfEvents {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        int n = events.length;
        int[][] memo = new int[n][k + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(0, k, events, memo);
    }

    private int findNext(int[][] events, int currEnd, int startIdx) {
        int low = startIdx, high = events.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (events[mid][0] > currEnd) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }

    private int dfs(int i, int k, int[][] events, int[][] memo) {
        if (i == events.length || k == 0) {
            return 0;
        }
        if (memo[i][k] != -1) {
            return memo[i][k];
        }

        int skip = dfs(i + 1, k, events, memo);

        int next = findNext(events, events[i][1], i + 1);
        int take = events[i][2] + dfs(next, k - 1, events, memo);

        return memo[i][k] = Math.max(skip, take);
    }
}
