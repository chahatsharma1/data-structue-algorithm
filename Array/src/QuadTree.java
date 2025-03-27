public class QuadTree {
    public Node construct(int[][] grid) {
        return buildQuadTree(grid, 0, 0, grid.length);
    }

    private Node buildQuadTree(int[][] grid, int row, int col, int size) {
        if (isUniform(grid, row, col, size)) { 
            return new Node(grid[row][col] == 1, true);
        }

        int halfSize = size / 2;
        Node topLeft = buildQuadTree(grid, row, col, halfSize);
        Node topRight = buildQuadTree(grid, row, col + halfSize, halfSize);
        Node bottomLeft = buildQuadTree(grid, row + halfSize, col, halfSize);
        Node bottomRight = buildQuadTree(grid, row + halfSize, col + halfSize, halfSize);

        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    private boolean isUniform(int[][] grid, int row, int col, int size) {
        int val = grid[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (grid[i][j] != val) {
                    return false;
                }
            }
        }
        return true;
    }
}