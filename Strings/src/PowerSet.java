import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PowerSet {
    public List<String> AllPossibleStrings(String s) {
        List<String> ans = new ArrayList<>();
        generateSubsequences(s, "", 0, ans);

        Collections.sort(ans);
        return ans;
    }

    private void generateSubsequences(String s, String current, int index, List<String> ans){
        if (index == s.length()){
            if (!current.isEmpty()){
                ans.add(current);
            }
            return;
        }
        generateSubsequences(s, current + s.charAt(index), index + 1, ans);

        generateSubsequences(s, current, index + 1, ans);
    }
}
