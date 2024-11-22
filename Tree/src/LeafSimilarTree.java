import java.util.ArrayList;

public class LeafSimilarTree {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        checkLeaves(root1, list1);
        checkLeaves(root2, list2);

        return list1.equals(list2);
    }

    private void checkLeaves(TreeNode root, ArrayList<Integer> list){
        if (root == null){
            return;
        }

        if (root.left == null && root.right == null){
            list.add(root.data);
            return;
        }

        checkLeaves(root.left, list);
        checkLeaves(root.right, list);
    }
}
