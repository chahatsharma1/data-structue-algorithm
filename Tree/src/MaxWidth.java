import java.util.LinkedList;
import java.util.Queue;

public class MaxWidth {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxWidth = 0;
        Queue<FakePair> queue = new LinkedList<>();
        queue.offer(new FakePair(0, root));

        while (!queue.isEmpty()){
            int size = queue.size();
            int min = queue.peek().index;
            int first = 0;
            int last = 0;
            for (int i = 0; i < size; i++) {
                if (queue.peek() != null) {
                    int currentIndex = queue.peek().index - min;
                    TreeNode temp = queue.peek().node;
                    queue.poll();
                    if (i == 0) {
                        first = currentIndex;
                    }
                    if (i == size - 1) {
                        last = currentIndex;
                    }
                    if (temp.left != null) {
                        queue.offer(new FakePair((2 * currentIndex) + 1, temp.left));
                    }
                    if (temp.right != null) {
                        queue.offer(new FakePair((2 * currentIndex) + 2, temp.right));
                    }
                }
            }
            maxWidth = Math.max(maxWidth, last - first + 1);
        }
        return maxWidth;
    }
}
