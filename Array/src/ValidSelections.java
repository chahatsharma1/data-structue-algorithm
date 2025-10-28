public class ValidSelections {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int validCount = 0;

        for (int start = 0; start < n; start++) {
            if (nums[start] == 0) {
                if (simulate(nums, start, 1)) {
                    validCount++;
                }
                if (simulate(nums, start, -1)) {
                    validCount++;
                }
            }
        }

        return validCount;
    }

    private boolean simulate(int[] nums, int start, int dir) {
        int n = nums.length;
        int[] arr = nums.clone();
        int curr = start;

        while (curr >= 0 && curr < n) {
            if (arr[curr] != 0) {
                arr[curr]--;
                dir = -dir;
            }
            curr += dir;
        }

        for (int num : arr) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}