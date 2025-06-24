import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(ans, 0, 0, n,  "");
        return ans;
    }
    private void helper(List<String> ans, int open, int close, int max, String current){
        if(current.length() == 2 * max){
            ans.add(current);
            return;
        }

        if(open < max){
            helper(ans, open + 1, close, max, current + "(");
        }

        if(close < open){
            helper(ans, open, close + 1, max, current + ")");
        }
    }
}
