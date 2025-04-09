import java.util.*;

public class OperationToMakeArrayEqualK {
    public int minOperations(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums){
            if (num < k){
                return -1;
            }
            if (num > k){
                set.add(num);
            }
        }
        return set.size();
    }
}
