public class OptimizedFruitPlacer {
    private int[] tree;
    private int[] baskets;
    private int n;

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        if (fruits == null || fruits.length == 0) {
            return 0;
        }

        this.n = baskets.length;
        this.baskets = baskets;
        this.tree = new int[4 * n];

        build(0, 0, n - 1);

        int unplacedCount = 0;
        for (int fruitQuantity : fruits) {
            int basketIndex = findLeftmostFit(fruitQuantity);

            if (basketIndex != -1) {
                update(basketIndex);
            } else {
                unplacedCount++;
            }
        }
        return unplacedCount;
    }

    private void update(int index) {
        updateNode(0, 0, n - 1, index, -1);
    }

    private int findLeftmostFit(int minCapacity) {
        if (tree[0] < minCapacity) {
            return -1;
        }
        return query(0, 0, n - 1, minCapacity);
    }

    private void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = baskets[start];
        } else {
            int mid = start + (end - start) / 2;
            int leftChild = 2 * node + 1;
            int rightChild = 2 * node + 2;
            build(leftChild, start, mid);
            build(rightChild, mid + 1, end);
            tree[node] = Math.max(tree[leftChild], tree[rightChild]);
        }
    }

    private void updateNode(int node, int start, int end, int idx, int val) {
        if (start == end) {
            tree[node] = val;
            return;
        }
        int mid = start + (end - start) / 2;
        int leftChild = 2 * node + 1;
        int rightChild = 2 * node + 2;

        if (idx <= mid) {
            updateNode(leftChild, start, mid, idx, val);
        } else {
            updateNode(rightChild, mid + 1, end, idx, val);
        }
        tree[node] = Math.max(tree[leftChild], tree[rightChild]);
    }

    private int query(int node, int start, int end, int minCapacity) {
        if (start == end) {
            return start;
        }

        int mid = start + (end - start) / 2;
        int leftChild = 2 * node + 1;
        int rightChild = 2 * node + 2;

        if (tree[leftChild] >= minCapacity) {
            return query(leftChild, start, mid, minCapacity);
        }

        return query(rightChild, mid + 1, end, minCapacity);
    }
}