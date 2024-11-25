public class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null){
            return null;
        }
        if (root.data > key){
            root.left = deleteNode(root.left, key);
        } else if (root.data < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null && root.right == null){
                return null;
            } else if (root.left == null){
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }else {
                TreeNode replacementNode = findMin(root.right);
                root.data = replacementNode.data;
                root.right = deleteNode(root.right, replacementNode.data);
            }
        }
        return root;
    }

    private TreeNode findMin(TreeNode node){
        while (node.left != null){
            node = node.left;
        }
        return node;
    }
}
