public class BinaryTreeDiameter {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return diameter;
    }

    private int helper(TreeNode node){
        if(node == null){
            return -1;
        }

        int left = helper(node.left) + 1;
        int right = helper(node.right) + 1;

        int max = left + right;
        diameter = Math.max(diameter, max);
        return Math.max(left, right);
    }
}
