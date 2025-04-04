public class LowestCommonAncestor {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return helper(root).node;
    }

    private Result helper(TreeNode root) {
        if (root == null) return new Result(null, 0);

        Result left = helper(root.left);
        Result right = helper(root.right);

        if (left.depth > right.depth) {
            return new Result(left.node, left.depth + 1);
        } else if (right.depth > left.depth) {
            return new Result(right.node, right.depth + 1);
        } else {
            return new Result(root, left.depth + 1);
        }
    }
}
