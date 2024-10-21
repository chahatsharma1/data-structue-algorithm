import java.util.*;

public class Clone{
    public Node cloneGraph(Node node) {
        if (node == null){
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        map.put(node, new Node(node.val, new ArrayList<>()));

        while (!queue.isEmpty()){
            Node currentNode = queue.poll();

            for (Node neighbor : currentNode.neighbors){
                if (!map.containsKey(neighbor)){
                    map.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.offer(neighbor);
                }
                map.get(currentNode).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}