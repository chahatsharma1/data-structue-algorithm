public class MaxOrSubsets {
    int count;
    int maxOr;
    int[] nums;
    int n;

    public int countMaxOrSubsets(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.count = 0;
        this.maxOr = 0;

        for (int num : nums) {
            this.maxOr |= num;
        }

        findSubsets(0, 0);
        return this.count;
    }

    private void findSubsets(int index, int currentOr) {
        if (currentOr == this.maxOr) {
            this.count += 1 << (this.n - index);
            return;
        }

        if (index == this.n) {
            return;
        }

        findSubsets(index + 1, currentOr | this.nums[index]);

        findSubsets(index + 1, currentOr);
    }
}