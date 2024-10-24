import java.util.ArrayList;

class RootToLeaf {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        findPaths(root, result, new ArrayList<>());
        return result;
    }

    private static void findPaths(Node root, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> currentPath){
        if (root == null){
            return;
        }

        currentPath.add(root.data);

        if (root.left == null && root.right == null){
            result.add(new ArrayList<>(currentPath));
        } else {
            findPaths(root.left, result, currentPath);
            findPaths(root.right, result, currentPath);
        }
        currentPath.removeLast();
    }
}