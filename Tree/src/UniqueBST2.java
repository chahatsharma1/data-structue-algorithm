import java.util.ArrayList;
import java.util.List;

public class UniqueBST2 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0){
            return new ArrayList<>();
        }
        return build(1, n);
    }

    private List<TreeNode> build(int start, int end){
        List<TreeNode> list = new ArrayList<>();
        if (start > end){
            list.add(null);
            return list;
        }

        for (int  i = start; i <= end; i++){
            List<TreeNode> left = build(start, i - 1);
            List<TreeNode> right = build(i + 1, end);

            for (TreeNode leftTree : left){
                for (TreeNode rightTree : right){
                    TreeNode node = new TreeNode(i, leftTree, rightTree);
                    list.add(node);
                }
            }
        }
        return list;
    }
}
