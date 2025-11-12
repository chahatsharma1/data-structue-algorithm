import java.util.*;

public class MinOperationsToMakeAllOne {
    public int minOperations(int[] nums) {
        int n = nums.length;

        int overallGcd = nums[0];
        for (int i = 1; i < n; i++) {
            overallGcd = gcd(overallGcd, nums[i]);
        }
        if (overallGcd > 1) {
            return -1;
        }

        int onesCount = 0;
        for (int num : nums) {
            if (num == 1) {
                onesCount++;
            }
        }
        if (onesCount > 0) {
            return n - onesCount;
        }

        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int g = nums[i];
            for (int j = i + 1; j < n; j++) {
                g = gcd(g, nums[j]);
                if (g == 1) {
                    minLength = Math.min(minLength, j - i + 1);
                    break;
                }
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return -1;
        }
        return (minLength - 1) + (n - 1);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
