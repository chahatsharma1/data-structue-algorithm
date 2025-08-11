import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        helper(nums, answer, 0, new ArrayList<Integer>());
        return answer;
    }
    
    private void helper(int[] nums, List<List<Integer>> answer, int index, List<Integer> current){
        answer.add(new ArrayList<>(current));
        for (int i = index; i < nums.length; i++){
            current.add(nums[i]);
            helper(nums, answer, i + 1, current);
            current.removeLast();
        }
    }
}