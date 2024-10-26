public class KthLargest {
    int count = 0;
    public int kthLargest(Node root, int k){
        return helper(root, k).data;
    }
    private Node helper(Node node, int k){
        if (node == null){
            return null;
        }
        Node right = helper(node.right, k);
        if (right != null){
            return right;
        }
        count++;
        if (count == k){
            return node;
        }
        return helper(node.left, k);
    }
}
