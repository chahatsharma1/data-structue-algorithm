public class CountGoodTriplets {
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] pos2 = new int[n];
        for (int i = 0; i < n; i++) {
            pos2[nums2[i]] = i;
        }

        BinaryIndexedTree leftBinaryIndexedTree = new BinaryIndexedTree(n);
        BinaryIndexedTree rightBinaryIndexedTree = new BinaryIndexedTree(n);
        int[] mapped = new int[n];
        for (int i = 0; i < n; i++) {
            mapped[i] = pos2[nums1[i]];
            rightBinaryIndexedTree.update(mapped[i], 1);
        }

        long result = 0;
        for (int i = 0; i < n; i++) {
            int midPos = mapped[i];
            rightBinaryIndexedTree.update(midPos, -1);

            int leftCount = leftBinaryIndexedTree.query(midPos - 1);
            int rightCount = rightBinaryIndexedTree.query(n - 1) - rightBinaryIndexedTree.query(midPos);

            result += (long) leftCount * rightCount;

            leftBinaryIndexedTree.update(midPos, 1);
        }
        return result;
    }
}
