public class Node {
    int data;
    int hd;
    Node left;
    Node right;

    Node(int item) {
        data = item;
        hd = Integer.MAX_VALUE;
        left = null;
        right = null;
    }
}
