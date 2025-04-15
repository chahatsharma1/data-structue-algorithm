public class BinaryIndexedTree {
    int[] tree;
    int size;

    public BinaryIndexedTree(int n) {
        size = n + 2;
        tree = new int[size];
    }

    public void update(int i, int delta) {
        i++;
        while (i < size) {
            tree[i] += delta;
            i += (i & -i);
        }
    }

    public int query(int i) {
        i++;
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= (i & -i);
        }
        return sum;
    }
}