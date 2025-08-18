import java.util.ArrayList;
import java.util.List;

public class CombinationsFromPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return ans;
        }
        helper("", digits, ans);
        return ans;
    }

    public void helper(String p, String up, List<String> ans) {
        if (up.isEmpty()) {
            ans.add(p);
            return;
        }

        int digit = up.charAt(0) - '0';
        String letters = getLetters(digit);

        for (char ch : letters.toCharArray()) {
            helper(p + ch, up.substring(1), ans);
        }
    }

    private String getLetters(int digit) {
        String[] digitMap = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        return digitMap[digit];
    }
}
