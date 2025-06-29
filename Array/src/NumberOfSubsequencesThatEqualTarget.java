import java.util.Arrays;

public class NumberOfSubsequencesThatEqualTarget {
    public static final int MOD = 1_000_000_007;

    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] pow = new int[n];
        pow[0] = 1;

        for (int i = 1; i < n; i++) {
            pow[i] = (pow[i - 1] * 2) % MOD;
        }
        int left = 0;
        int right = n -1;
        int count = 0;


        while (left <= right){
            if(nums[left] + nums[right] <= target){
                count = (count + pow[right - left]) % MOD;
                left++;
            } else {
                right--;
            }
        }
        return count;
    }
}