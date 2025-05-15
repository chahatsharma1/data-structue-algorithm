import java.util.ArrayList;
import java.util.List;

public class LongestUnequalSubsequence {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        int lastGroup = -1;

        for (int i = 0; i < words.length; i++) {
            if (lastGroup == -1 || groups[i] != lastGroup) {
                result.add(words[i]);
                lastGroup = groups[i];
            }
        }

        return result;
    }
}