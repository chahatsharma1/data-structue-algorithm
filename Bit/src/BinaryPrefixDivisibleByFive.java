import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivisibleByFive {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> result = new ArrayList<>();
        int x = 0;

        for (int bit : nums) {
            x = (x * 2 + bit) % 5;
            result.add(x == 0);
        }
        return result;
    }
}