import java.util.*;

public class DungeonMinimumTime2 {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;

        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        dist[0][0] = 0;
        pq.offer(new int[]{0, 0, 0});

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentTime = current[0];
            int r = current[1];
            int c = current[2];

            if (currentTime > dist[r][c]) {
                continue;
            }

            if (r == n - 1 && c == m - 1) {
                return currentTime;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    int startMoveTime = Math.max(currentTime, moveTime[nr][nc]);

                    int arrivalTime = startMoveTime + 1;

                    if (arrivalTime < dist[nr][nc]) {
                        dist[nr][nc] = arrivalTime;
                        pq.offer(new int[]{arrivalTime, nr, nc});
                    }
                }
            }
        }
        return dist[n - 1][m - 1] == Integer.MAX_VALUE ? -1 : dist[n - 1][m - 1];
    }
}
