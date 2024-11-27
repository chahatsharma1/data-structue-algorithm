import javax.swing.tree.TreeCellRenderer;
import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        helper(root, ans, currentList, targetSum);
        return ans;
    }

    private void helper(TreeNode root, List<List<Integer>> ans, List<Integer> currentList, int targetSum){
        if (root == null){
            return;
        }

        currentList.add(root.data);

        if (root.left == null && root.right == null && root.data == targetSum){
            ans.add(new ArrayList<>(currentList));
        } else {
            helper(root.left, ans, currentList, targetSum - root.data);
            helper(root.right, ans, currentList, targetSum - root.data);
        }
        currentList.remove(currentList.size() - 1);
    }
}
