import java.lang.Math;

public class LongestVShapedDiagonalSegment {
    public int longestVShapedSegment(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int n = grid.length;
        int m = grid[0].length;
        int maxLength = 0;

        int[][] dirs = {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}};

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == 1) {
                    maxLength = Math.max(maxLength, 1);

                    for (int i = 0; i < 4; i++) {
                        int[] dir1 = dirs[i];
                        int[] dir2 = dirs[(i + 1) % 4];

                        int r1 = r;
                        int c1 = c;
                        int len1 = 1;

                        while (true) {
                            int r2 = r1;
                            int c2 = c1;
                            int len2 = 0;

                            while (true) {
                                int nextR2 = r2 + dir2[0];
                                int nextC2 = c2 + dir2[1];

                                if (nextR2 < 0 || nextR2 >= n || nextC2 < 0 || nextC2 >= m) {
                                    break;
                                }

                                int totalLen = len1 + len2 + 1;
                                int expected = (totalLen % 2 == 0) ? 2 : 0;

                                if (grid[nextR2][nextC2] != expected) {
                                    break;
                                }

                                len2++;
                                r2 = nextR2;
                                c2 = nextC2;
                            }
                            maxLength = Math.max(maxLength, len1 + len2);

                            int nextR1 = r1 + dir1[0];
                            int nextC1 = c1 + dir1[1];

                            if (nextR1 < 0 || nextR1 >= n || nextC1 < 0 || nextC1 >= m) {
                                break;
                            }

                            int expected = ((len1 + 1) % 2 == 0) ? 2 : 0;
                            if (grid[nextR1][nextC1] != expected) {
                                break;
                            }

                            len1++;
                            r1 = nextR1;
                            c1 = nextC1;
                        }
                    }
                }
            }
        }
        return maxLength;
    }
}