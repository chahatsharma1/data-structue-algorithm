import java.util.*;

public class FindAllKDistantIndicesArray {
    public static List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == key){
                for(int j = Math.max(0, i - k); j <= Math.min(nums.length - 1, i + k); j++){
                    set.add(j);
                }
            }
        }

        List<Integer> result = new ArrayList<>(set);
        Collections.sort(result);
        return result;
    }
}