public class BSTFromPreOrder {
    private int index = 0;

    public TreeNode bstFromPreorder(int[] preorder){
        return buildTree(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode buildTree(int[] preorder, int minValue, int maxValue) {
        if(index >= preorder.length || preorder[index] < minValue || preorder[index] > maxValue){
            return null;
        }

        int currentValue = preorder[index++];
        TreeNode node = new TreeNode(currentValue);

        node.left = buildTree(preorder, minValue, currentValue);
        node.right = buildTree(preorder, currentValue, maxValue);

        return node;
    }

}
