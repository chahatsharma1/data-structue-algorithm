class BinaryTreeTilt {
    private int totalTilt = 0;

    public int findTilt(TreeNode root) {
        sumAndTilt(root);
        return totalTilt;
    }

    private int sumAndTilt(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftSum = sumAndTilt(node.left);
        int rightSum = sumAndTilt(node.right);

        int nodeTilt = Math.abs(leftSum - rightSum);

        totalTilt += nodeTilt;

        return node.data + leftSum + rightSum;
    }
}