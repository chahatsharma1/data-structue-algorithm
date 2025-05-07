import java.util.*;

public class DungeonMinimumTime {
    public int minimumTime(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0});

        int[][] minTime = new int[n][m];
        for (int[] row : minTime) {
            Arrays.fill(row, Integer.MAX_VALUE);
            minTime[0][0] = 0;
        }


        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0];
            int x = curr[1];
            int y = curr[2];

            if (x == n - 1 && y == m - 1)
                return time;

            for (int[] dir : directions) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;

                int newTime = time + 1;
                if (newTime < moveTime[nx][ny]) {
                    newTime = moveTime[nx][ny];
                }

                if (newTime < minTime[nx][ny]) {
                    minTime[nx][ny] = newTime;
                    pq.offer(new int[]{newTime, nx, ny});
                }
            }
        }
        return -1;
    }
}
