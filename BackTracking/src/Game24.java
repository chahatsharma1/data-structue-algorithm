import java.util.ArrayList;
import java.util.List;

public class Game24 {
    private static final double TARGET = 24;
    private static final double EPSILON = 1e-6;

    public boolean judgePoint24(int[] cards) {
        List<Double> list = new ArrayList<>();
        for (int card : cards) {
            list.add((double) card);
        }
        return solve(list);
    }

    private boolean solve(List<Double> nums) {
        if (nums.size() == 1) {
            return Math.abs(nums.getFirst() - TARGET) < EPSILON;
        }

        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {

                List<Double> nextRoundNums = new ArrayList<>();
                for (int k = 0; k < nums.size(); k++) {
                    if (k != i && k != j) {
                        nextRoundNums.add(nums.get(k));
                    }
                }

                double a = nums.get(i);
                double b = nums.get(j);

                List<Double> results = new ArrayList<>();
                results.add(a + b);
                results.add(a * b);
                results.add(a - b);
                results.add(b - a);
                if (Math.abs(b) > EPSILON) {
                    results.add(a / b);
                }
                if (Math.abs(a) > EPSILON) {
                    results.add(b / a);
                }

                for (double res : results) {
                    nextRoundNums.add(res);
                    if (solve(nextRoundNums)) {
                        return true;
                    }
                    nextRoundNums.removeLast();
                }
            }
        }
        return false;
    }
}