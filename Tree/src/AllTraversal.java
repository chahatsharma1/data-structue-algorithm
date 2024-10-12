import java.util.ArrayList;
import java.util.List;

public class AllTraversal {
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> inOrderList = new ArrayList<>();
        List<Integer> preOrderList = new ArrayList<>();
        List<Integer> postOrderList = new ArrayList<>();

        // Perform the three traversals
        inOrderTraversal(root, inOrderList);
        preOrderTraversal(root, preOrderList);
        postOrderTraversal(root, postOrderList);

        // Add the lists to the result in the required order
        result.add(inOrderList);
        result.add(preOrderList);
        result.add(postOrderList);

        return result;
    }

    private static void inOrderTraversal(TreeNode node, List<Integer> inOrderList) {
        if (node == null) return;
        inOrderTraversal(node.left, inOrderList);
        inOrderList.add(node.data);
        inOrderTraversal(node.right, inOrderList);
    }

    private static void preOrderTraversal(TreeNode node, List<Integer> preOrderList) {
        if (node == null) return;
        preOrderList.add(node.data);
        preOrderTraversal(node.left, preOrderList);
        preOrderTraversal(node.right, preOrderList);
    }

    private static void postOrderTraversal(TreeNode node, List<Integer> postOrderList) {
        if (node == null) return;
        postOrderTraversal(node.left, postOrderList);
        postOrderTraversal(node.right, postOrderList);
        postOrderList.add(node.data);
    }
}