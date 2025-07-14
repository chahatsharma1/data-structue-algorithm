import java.util.HashMap;

public class LRUCache {

    int capacity;
    HashMap<Integer, Node2> map;
    Node2 head;
    Node2 tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node2(0, 0);
        this.tail = new Node2(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node2 node2 = map.get(key);
            removeNode(node2);
            addInFront(node2);
            return node2.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node2 doubleLL = map.get(key);
            doubleLL.value = value;
            removeNode(doubleLL);
            addInFront(doubleLL);
        } else {
            if(map.size() >= capacity){
                Node2 doubleLL = tail.prev;
                removeNode(doubleLL);
                map.remove(doubleLL.key);
            }
            Node2 doubleLL = new Node2(key,value);
            addInFront(doubleLL);
            map.put(key, doubleLL);
        }
    }

    private void removeNode(Node2 node){
        Node2 prevDoubleLL = node.prev;
        Node2 nextDoubleLL = node.next;
        prevDoubleLL.next = nextDoubleLL;
        nextDoubleLL.prev = prevDoubleLL;
    }

    private void addInFront(Node2 node){
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }
}
