import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationTargetSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, ans, target, 0, new ArrayList<>());
        return ans;
    }
    private void helper(int[] candidates, List<List<Integer>> ans, int target, int start, List<Integer> tempList){
        if (target < 0){
            return;
        } else if (target == 0){
            ans.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i -1]){
                    continue;
                }
                tempList.add(candidates[i]);
                helper(candidates, ans, target - candidates[i], i + 1, tempList);
                tempList.removeLast();
            }
        }
    }
}