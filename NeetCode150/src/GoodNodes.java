public class GoodNodes {
    public int goodNodes(TreeNode root) {
        if (root == null){
            return 0;
        }
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode node, int max){
        if(node == null){
            return 0;
        }

        int count = node.val >= max ? 1 : 0;
        max = Math.max(max, node.val);

        count += dfs(node.left, max);
        count += dfs(node.right, max);

        return count;
    }
}
