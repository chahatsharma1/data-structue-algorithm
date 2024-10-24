import java.util.ArrayList;
import java.util.Stack;

class BoundaryTraversal {
	public static ArrayList<Integer> boundary(Node node) {
	    ArrayList<Integer> result = new ArrayList<>();
		if (!isLeaf(node)){
			result.add(node.data);
		}
		addLeftBoundary(node, result);
		addLeaf(node, result);
		addRightBoundary(node, result);
		return result;
	}

	private static void addLeftBoundary(Node node, ArrayList<Integer> result) {
		Node current = node.left;
		while (current != null){
			if (!isLeaf(current)){
				result.add(current.data);
			}
			if (current.left != null) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
	}

	private static void addLeaf(Node node, ArrayList<Integer> result) {
		if (isLeaf(node)){
			result.add(node.data);
			return;
		}
		if (node.left != null){
			addLeaf(node.left, result);
		}
		if (node.right != null){
			addLeaf(node.right, result);
		}
	}

	private static void addRightBoundary(Node node, ArrayList<Integer> result){
		Node current = node.right;
		Stack<Integer> stack = new Stack<>();
		while (current != null){
			if (!isLeaf(current)){
				stack.push(current.data);
			}
			if (current.right != null){
				current = current.right;
			} else {
				current = current.left;
			}
		}
		while (!stack.isEmpty()){
			result.add(stack.pop());
		}
	}

	private static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }
}