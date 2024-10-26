public class ChildrenSum {
    public static int isSumProperty(Node root) {
        if (root == null){
            return 1;
        }
        if (root.left == null && root.right == null){
            return 1;
        }

        int leftValue = (root.left != null) ? root.left.data : 0;
        int rightValue = (root.right != null) ? root.right.data : 0;

        if (root.data == leftValue + rightValue){
            int left = isSumProperty(root.left);
            int right = isSumProperty(root.right);

            return (left == 1 && right == 1) ? 1 : 0;
        }
        else {
            return 0;
        }
    }
}