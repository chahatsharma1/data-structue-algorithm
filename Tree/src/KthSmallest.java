public class KthSmallest {
    int count = 0;
    public int kthSmallest(TreeNode root, int k){
        return helper(root, k).data;
    }

    private TreeNode helper(TreeNode node, int k){
        if (node == null){
            return null;
        }
        TreeNode left = helper(node.left, k);

        if (left != null){
            return left;
        }
        count++;

        if (count == k){
            return node;
        }
        return helper(node.right, k);
    }
}