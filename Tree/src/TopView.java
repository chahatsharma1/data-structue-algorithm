import java.util.*;

public class TopView {
    public static ArrayList<Integer> bottomList(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.remove();
            int hd = pair.hd;
            Node temp = pair.node;
            map.computeIfAbsent(hd, k -> temp.data);
            if (temp.left != null) {
                queue.add(new Pair(temp.left, hd - 1));
            }

            if (temp.right != null) {
                temp.right.hd = hd + 1;
                queue.add(new Pair(temp.right, hd + 1));
            }
        }
        ans.addAll(map.values());
        return ans;
    }
}