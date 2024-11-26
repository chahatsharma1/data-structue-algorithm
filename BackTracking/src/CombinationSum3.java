import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, new ArrayList<>(), k, n, 1);
        return ans;
    }

    private void helper(List<List<Integer>> ans, ArrayList<Integer> currentList, int k, int n, int start){
        if (currentList.size() == k && n == 0){
            ans.add(new ArrayList<>(currentList));
            return;
        }

        if (currentList.size() > k || n < 0){
            return;
        }

        for (int i = start; i <= 9; i++) {
            currentList.add(i);
            helper(ans, currentList, k, n - i, i + 1);
            currentList.remove(currentList.size() - 1);
        }
    }
}
