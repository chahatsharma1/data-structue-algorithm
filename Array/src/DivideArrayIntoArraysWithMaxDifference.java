import java.util.Arrays;

public class DivideArrayIntoArraysWithMaxDifference {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        if(n % 3 != 0){
            return new int[0][];
        }

        int[][] result = new int[n / 3][3];
        int i = 0;

        for(int j = 0; j < n; j += 3){
            int a = nums[j];
            int b = nums[j + 1];
            int c = nums[j + 2];

            if(c - a > k){
                return new int[0][];
            }

            result[i++] = new int[]{a, b, c};
        }
        return result;
    }
}
