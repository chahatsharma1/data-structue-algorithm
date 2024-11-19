import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringConcatenationAllWords {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> ans = new ArrayList<>();
        if (s.isEmpty() || words == null) {
            return ans;
        }

        int wordLength = words[0].length();
        int substringLength = wordLength * words.length;

        HashMap<String, Integer> wordFreq = new HashMap<>();
        for (String word : words) {
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLength; i++) {
            int left = i;
            int right = i;

            HashMap<String, Integer> currentFreq = new HashMap<>();

            while (right + wordLength <= s.length()){
                String currentWord = s.substring(right, right + wordLength);
                right += wordLength;

                if (wordFreq.containsKey(currentWord)){
                    currentFreq.put(currentWord, currentFreq.getOrDefault(currentWord, 0) + 1);

                    while (currentFreq.get(currentWord) > wordFreq.get(currentWord)){
                        String leftWord = s.substring(left, left + wordLength);
                        currentFreq.put(leftWord, currentFreq.get(leftWord) - 1);
                        left += wordLength;
                    }

                    if (right - left == substringLength){
                        ans.add(left);
                    }
                } else {
                    currentFreq.clear();
                    left = right;
                }

            }
        }
        return ans;
    }
}
