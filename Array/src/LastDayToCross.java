import java.util.*;

public class LastDayToCross {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 0;
        int right = cells.length;
        int answer = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canCross(row, col, cells, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }

    private boolean canCross(int row, int col, int[][] cells, int day) {
        int[][] grid = new int[row][col];

        for (int i = 0; i < day; i++) {
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;
            grid[r][c] = 1;
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];

        for (int c = 0; c < col; c++) {
            if (grid[0][c] == 0) {
                queue.offer(new int[]{0, c});
                visited[0][c] = true;
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];

            if (x == row - 1) {
                return true;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && ny >= 0 && nx < row && ny < col && !visited[nx][ny] && grid[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        return false;
    }
}
