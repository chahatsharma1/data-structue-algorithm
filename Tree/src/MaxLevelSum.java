import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSum {
    public int maxLevelSum(TreeNode root) {
        if (root == null){
            return 0;
        }

        int maxSum = Integer.MIN_VALUE;
        int maxSumLevel = 1;
        int currentLevel = 1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int levelSize = queue.size();
            int currentSum = 0;

            for (int i = 0; i < levelSize; i++){
                TreeNode currentNode = queue.poll();
                currentSum += currentNode.data;

                if (currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }

            if (maxSum < currentSum){
                maxSum = currentSum;
                maxSumLevel = currentLevel;
            }
            currentLevel++;
        }
        return maxSumLevel;
    }
}
