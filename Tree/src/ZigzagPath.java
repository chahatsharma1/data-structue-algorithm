public class ZigzagPath {
    private int maxLength = 0;
    public int longestZigZag(TreeNode root) {
        if (root == null){
            return 0;
        }

        dfs(root.left, 1, true);
        dfs(root.right, 1, false);

        return maxLength;
    }

    private void dfs(TreeNode root, int length, Boolean isLeft){
        if (root == null){
            return;
        }

        maxLength = Math.max(length, maxLength);

        if (isLeft){
            dfs(root.right, length + 1, false);
            dfs(root.left, 1, true);
        } else {
            dfs(root.left, length + 1, true);
            dfs(root.right, 1, false);
        }
    }
}
