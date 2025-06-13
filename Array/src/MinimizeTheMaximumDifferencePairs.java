import java.util.Arrays;

public class MinimizeTheMaximumDifferencePairs {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums[nums.length - 1] - nums[0];
        int ans = end;

        while (start <= end){
            int mid = start + (end - start) / 2;
            if (canMakePair(nums, mid, p)){
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private boolean canMakePair(int[] nums, int mid, int p){
        int count = 0;
        int i = 0;
        while (i < nums.length - 1){
            if (nums[i + 1] - nums[i] <= mid){
                count++;
                i += 2;
            } else {
                i++;
            }
        }
        return count >= p;
    }
}
