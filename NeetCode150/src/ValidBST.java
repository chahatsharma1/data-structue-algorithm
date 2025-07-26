public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode node, Integer low, Integer high){
        if(node == null){
            return true;
        }

        if((low != null && node.val <= low) || (high != null && node.val >= high)){
            return false;
        }

        boolean left = isValidBST(node.left, low, node.val);
        boolean right = isValidBST(node.right, node.val, high);

        return left && right;
    }
}
