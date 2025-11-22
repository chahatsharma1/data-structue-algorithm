public class FindMinimumOperationsToMakeAllElementsThree {
    public int minOperations(int[] nums) {
        int operations = 0;

        for (int num : nums) {
            int rem = num % 3;
            if (rem == 1 || rem == 2) {
                operations += 1;
            }
        }
        return operations;
    }
}
