import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MaxTreeXORSum {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long totalSum = 0;
        List<Long> positiveGains = new ArrayList<>();
        List<Long> negativeGains = new ArrayList<>();

        for (int num : nums) {
            long currentNum = num;
            long xorNum = currentNum ^ k;
            long gain = xorNum - currentNum;

            totalSum += currentNum;

            if (gain > 0) {
                positiveGains.add(gain);
            } else if (gain < 0) {
                negativeGains.add(gain);
            }
        }

        long sumOfPositiveGains = 0;
        for (long gain : positiveGains) {
            sumOfPositiveGains += gain;
        }

        long maxSumConsideringAllPositiveGains = totalSum + sumOfPositiveGains;

        if (positiveGains.size() % 2 == 0) {
            return maxSumConsideringAllPositiveGains;
        } else {
            long option1Sum = -Long.MAX_VALUE;
            if (!positiveGains.isEmpty()) {
                long minPositiveGain = Collections.min(positiveGains);
                option1Sum = maxSumConsideringAllPositiveGains - minPositiveGain;
            }

            long option2Sum = -Long.MAX_VALUE;
            if (!negativeGains.isEmpty()) {
                long maxNegativeGain = Collections.max(negativeGains);
                option2Sum = maxSumConsideringAllPositiveGains + maxNegativeGain;
            }

            return Math.max(option1Sum, option2Sum);
        }
    }
}
