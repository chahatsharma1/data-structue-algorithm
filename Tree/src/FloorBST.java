public class FloorBST {
    public static int floorInBST(TreeNode root, int X) {
        int ans = -1;
        while (root != null){
            if (root.data <= X){
                ans = root.data;
                root = root.right;
            }else {
                root = root.left;
            }
        }
        return ans;
    }
}
