import java.util.*;

public class BottomView {
    public static ArrayList<Integer> bottomList(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Node> queue = new LinkedList<>();
        root.hd = 0;
        queue.add(root);

        while (!queue.isEmpty()){
            Node temp = queue.remove();
            int hd = temp.hd;
            map.put(hd, temp.data);

            if (temp.left != null){
                temp.left.hd = hd - 1;
                queue.add(temp.left);
            }

            if (temp.right != null){
                temp.right.hd = hd + 1;
                queue.add(temp.right);
            }
        }
        ans.addAll(map.values());
        return ans;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(3);
        node.right = new Node(2);
        System.out.println(bottomList(node));
    }
}
