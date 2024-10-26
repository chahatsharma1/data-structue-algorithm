public class MaximumSumInBST {
    int maxSum;
    public int LargestBST(TreeNode root) {
        maxSum = 0;
        helper(root);
        return maxSum;
    }
    private NodeValue helper(TreeNode root){
        if (root == null){
            return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, true);
        }

        NodeValue left = helper(root.left);
        NodeValue right = helper(root.right);
        if (left.isBST && right.isBST && left.max < root.data && root.data < right.min){
            int currentSize = left.size + right.size + root.data;
            maxSum = Math.max(maxSum, currentSize);
            return new NodeValue(
                    Math.max(root.data, right.max),
                    Math.min(left.min, root.data),
                    currentSize,
                    true);
        }
        return new NodeValue(0, 0, Math.max(left.size, right.size), false);
    }
}
