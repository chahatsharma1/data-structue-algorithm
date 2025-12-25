import java.util.Arrays;

public class MaximizeHappinessOfSelectedChildren {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);

        long maxSum = 0;
        int turns = 0;

        for (int i = happiness.length - 1; i >= 0 && turns < k; i--) {
            int current = happiness[i] - turns;
            if (current <= 0) {
                break; 
            }
            maxSum += current;
            turns++;
        }

        return maxSum;
    }
}