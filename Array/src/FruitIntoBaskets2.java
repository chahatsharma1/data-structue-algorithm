public class FruitIntoBaskets2 {
    public int unplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        boolean[] used = new boolean[n];
        int unplacedCount = 0;

        for (int fruit : fruits) {
            boolean placed = false;

            for (int j = 0; j < n; j++) {
                if (!used[j] && baskets[j] >= fruit) {
                    used[j] = true;
                    placed = true;
                    break;
                }
            }

            if (!placed) {
                unplacedCount++;
            }
        }
        return unplacedCount;
    }
}