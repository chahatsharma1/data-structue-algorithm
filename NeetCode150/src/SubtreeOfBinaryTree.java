public class SubtreeOfBinaryTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null){
            return false;
        }
        return isSame(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSame(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null){
            return true;
        }
        if(node1 == null || node2 == null){
            return false;
        }

        if(node1.val != node2.val){
            return false;
        }
        return isSame(node1.left, node2.left) && isSame(node1.right, node2.right);
    }
}