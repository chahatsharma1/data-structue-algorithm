import java.util.HashMap;
import java.util.Map;

class PathSum3 {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        return helper(root, map, targetSum, 0L);
    }

    private int helper(TreeNode root, Map<Long, Integer> map, int targetSum, Long currentSum){
        if (root == null){
            return 0;
        }

        currentSum += root.data;

        int pathCount = map.getOrDefault(currentSum - targetSum, 0);

        map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);

        pathCount += helper(root.left, map, targetSum, currentSum);
        pathCount += helper(root.right, map, targetSum, currentSum);

        map.put(currentSum, map.get(currentSum) - 1);

        return pathCount;
    }
}