public class MaximumFruitsHarvested {
    public int maxFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int maxFruits = 0;
        int total = 0;

        int left = 0;
        for (int right = 0; right < n; right++) {
            total += fruits[right][1];

            while (left <= right && !isReachable(fruits, left, right, startPos, k)) {
                total -= fruits[left][1];
                left++;
            }
            maxFruits = Math.max(maxFruits, total);
        }
        return maxFruits;
    }

    private boolean isReachable(int[][] fruits, int left, int right, int startPos, int k) {
        int leftPos = fruits[left][0];
        int rightPos = fruits[right][0];

        int dist1 = Math.abs(startPos - leftPos) + (rightPos - leftPos);
        int dist2 = Math.abs(startPos - rightPos) + (rightPos - leftPos);

        return Math.min(dist1, dist2) <= k;
    }
}
