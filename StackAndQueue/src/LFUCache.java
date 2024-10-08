import java.util.HashMap;

class LFUCache {
    static class Node{
        int key;
        int value;
        int freq;
        Node prev;
        Node next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    static class DLList{
        Node head;
        Node tail;
        int size;

        public DLList(){
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void addInFront(Node node){
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        public void removeNode(Node node){
            Node nextNode = node.next;
            Node prevNode = node.prev;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            size--;
        }

        public Node removeLast(){
            if (size > 0) {
                Node last = tail.prev;
                removeNode(last);
                return last;
            }
            return null;
        }
    }

    private final int capacity;
    private int minFreq;
    private final HashMap<Integer, Node> map;
    private final HashMap<Integer, DLList> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.map = new HashMap<>();
        this.freqMap = new HashMap<>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        updateFreq(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0){
            return;
        }
        if (map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            updateFreq(node);
        }
        else {
            if (map.size() >= capacity){
                removeLFU();
            }

            Node node = new Node(key, value);
            map.put(key, node);
            freqMap.computeIfAbsent(1, k -> new DLList()).addInFront(node);
            minFreq = 1;
        }
    }

    private void updateFreq(Node node) {
        int freq = node.freq;
        DLList list = freqMap.get(freq);
        list.removeNode(node);

        if (list.size == 0 && minFreq == freq){
            minFreq++;
        }
        node.freq++;
        freqMap.computeIfAbsent(node.freq, k -> new DLList()).addInFront(node);
    }

    private void removeLFU(){
        DLList list = freqMap.get(minFreq);
        Node node = list.removeLast();
        if (node != null){
            map.remove(node.key);
        }
    }
}