public class GoodNode {
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode node, int max){
        if (node == null){
            return 0;
        }

        int count = node.data >= max ? 1 : 0;

        max = Math.max(node.data, max);

        count += dfs(node.left, max);
        count += dfs(node.right, max);

        return count;
    }
}
