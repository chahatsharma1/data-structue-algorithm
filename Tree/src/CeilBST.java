public class CeilBST {
    public static int floorInBST(TreeNode node, int X) {
        int ans = -1;
        while (node != null){
            if (node.data >= X){
                ans = node.data;
                node = node.left;
            }else {
                node = node.right;
            }
        }
        return ans;
    }
}
