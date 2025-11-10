import java.util.ArrayList;
import java.util.List;

public class MinOperationsToConvertAllElementsToZero {
    public int minOperations(int[] nums) {
        List<Integer> s = new ArrayList<>();
        int res = 0;
        for (int a : nums) {
            while (!s.isEmpty() && s.getLast() > a) {
                s.removeLast();
            }
            if (a == 0) {
                continue;
            }
            if (s.isEmpty() || s.getLast() < a) {
                res++;
                s.add(a);
            }
        }
        return res;
    }
}