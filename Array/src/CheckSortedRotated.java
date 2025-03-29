public class CheckSortedRotated {
    public boolean check(int[] nums) {
        int countDrop = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // Check for a drop in sorted order
            if (nums[i] > nums[(i + 1) % n]) {
                countDrop++;
            }

            if (countDrop > 1) {
                return false;
            }
        }
        return true;
    }
}
