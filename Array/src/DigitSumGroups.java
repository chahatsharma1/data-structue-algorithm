import java.util.*;

public class DigitSumGroups {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> groupCount = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            int sum = getDigitSum(i);
            groupCount.put(sum, groupCount.getOrDefault(sum, 0) + 1);
        }

        int maxSize = Collections.max(groupCount.values());
        int count = 0;
        for (int size : groupCount.values()) {
            if (size == maxSize) {
                count++;
            }
        }
        return count;
    }

    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
