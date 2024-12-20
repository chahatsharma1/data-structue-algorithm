import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReverseOddLevels {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null){
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isOdd = false;

        while (!queue.isEmpty()){
            int size = queue.size();
            List<TreeNode> list = new ArrayList<>();

            for (int i = 0; i < size; i++){
                TreeNode current = queue.poll();
                list.add(current);

                if (current.left != null){
                    queue.offer(current.left);
                }
                if (current.right != null){
                    queue.add(current.right);
                }
            }
            if (isOdd){
                int start = 0;
                int end = list.size() - 1;

                while (start < end){
                    int temp = list.get(start).data;
                    list.get(start).data = list.get(end).data;
                    list.get(end).data = temp;
                    start++;
                    end--;
                }
            }
            isOdd = !isOdd;
        }
        return root;
    }
}
