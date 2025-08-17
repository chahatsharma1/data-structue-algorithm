import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        helper(s, result, new ArrayList<>(), 0);
        return result;
    }

    private void helper(String s, List<List<String>> result, List<String> tempList, int index){
        if (index == s.length()){
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = index; i < s.length(); i++){
            if (isPalindrome(s, index, i)){
                tempList.add(s.substring(index, i + 1));
                helper(s, result, tempList, i + 1);
                tempList.removeLast();
            }
        }
    }
    private boolean isPalindrome(String s, int start, int end){
        while (start <= end){
            if (s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}