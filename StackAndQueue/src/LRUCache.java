import java.util.HashMap;

class LRUCache {
    static class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final HashMap<Integer, Node> map;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            removeNode(node);
            addNodeInFront(node);
            return node.value;
        }
        return -1;
    }

    private void addNodeInFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;

    }

    private void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            removeNode(node);
            addNodeInFront(node);
        }
        else {
            if (map.size() >= capacity){
                Node node = tail.prev;
                removeNode(node);
                map.remove(node.key);
            }
            Node node = new Node(key, value);
            addNodeInFront(node);
            map.put(key, node);
        }
    }
}