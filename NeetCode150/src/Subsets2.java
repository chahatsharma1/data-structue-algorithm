import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, answer, 0, new ArrayList<Integer>());
        return answer;
    }

    private void helper(int[] nums, List<List<Integer>> answer, int index, List<Integer> current){
        answer.add(new ArrayList<>(current));
        for (int i = index; i < nums.length; i++){
            if (i > index && nums[i] == nums[i - 1]){
                continue;
            }
            current.add(nums[i]);
            helper(nums, answer, i + 1, current);
            current.removeLast();
        }
    }
}