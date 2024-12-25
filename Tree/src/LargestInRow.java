import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestInRow {
    public List<Integer> largestValue(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < size; i++){
                TreeNode current = queue.poll();
                max = Math.max(max, current.data);

                if (current.left != null){
                    queue.offer(current.left);
                }

                if (current.right != null){
                    queue.offer(current.right);
                }
            }

            ans.add(max);
        }
        return ans;
    }
}
