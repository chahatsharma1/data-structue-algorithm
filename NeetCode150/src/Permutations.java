import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, ans, new ArrayList<>());
        return ans;
    }

    private void helper(int[] nums, List<List<Integer>> ans, List<Integer> tempList){
        if(tempList.size() == nums.length){
            ans.add(new ArrayList<>(tempList));
        } else {
            for(int num : nums){
                if (!tempList.contains(num)) {
                    tempList.add(num);
                    helper(nums, ans, tempList);
                    tempList.removeLast();
                }
            }
        }
    }
}
